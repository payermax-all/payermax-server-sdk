package com.payermax.sdk.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * OpenAPI 文档解析和 Java 请求类生成器
 * <p>
 * 使用方法：直接运行 main 方法
 */
public class OpenApiCodeGenerator {

    private static final String PROJECT_ROOT = System.getProperty("user.dir");
    private static final String OPENAPI_FILE = PROJECT_ROOT + "/api.json";
    private static final String REQ_OUTPUT_DIR = PROJECT_ROOT + "/src/main/java/com/payermax/sdk/req";
    private static final String RESP_OUTPUT_DIR = PROJECT_ROOT + "/src/main/java/com/payermax/sdk/resp";
    private static final String BASE_PACKAGE = "com.payermax.sdk";

    public static void main(String[] args) {
        try {
            System.out.println("开始解析 OpenAPI 文档...");
            System.out.println("文件路径: " + OPENAPI_FILE);

            String content = readFile(OPENAPI_FILE);
            JSONObject openapi = JSON.parseObject(content);

            List<ApiInfo> apis = parseApis(openapi);
            System.out.println("共解析到 " + apis.size() + " 个 API 接口");

            // 获取已存在的请求类
            Set<String> existingReqClasses = getExistingRequestClasses();
            Set<String> existingRespClasses = getExistingResponseClasses();
            System.out.println("已存在 " + existingReqClasses.size() + " 个请求类，" + existingRespClasses.size() + " 个响应类（将被覆盖）");

            // 生成代码（直接覆盖已存在的类）
            int count = 0;
            for (ApiInfo api : apis) {
                String className = getRequestClassName(api.apiName);
                String respClassName = getResponseClassName(api.apiName);

                // 生成请求类（覆盖已存在的）
                String reqCode = generateRequestClass(api);
                writeFile(Paths.get(REQ_OUTPUT_DIR, className + ".java"), reqCode);

                // 生成响应类（覆盖已存在的）
                String respCode = generateResponseClass(api);
                writeFile(Paths.get(RESP_OUTPUT_DIR, respClassName + ".java"), respCode);

                count++;
            }

            System.out.println("\n完成！共生成 " + count + " 个新的请求类和响应类");

        } catch (Exception e) {
            System.err.println("生成失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 解析 API 接口信息
     */
    private static List<ApiInfo> parseApis(JSONObject openapi) {
        List<ApiInfo> apis = new ArrayList<>();
        JSONObject paths = openapi.getJSONObject("paths");

        if (paths == null) {
            return apis;
        }

        for (String path : paths.keySet()) {
            JSONObject methods = paths.getJSONObject(path);
            for (String method : methods.keySet()) {
                if (!Arrays.asList("get", "post", "put", "delete", "patch").contains(method.toLowerCase())) {
                    continue;
                }

                JSONObject details = methods.getJSONObject(method);
                String summary = details.getString("summary");
                String description = details.getString("description");
                String apiName = extractApiName(description, path);

                // 跳过回调通知类接口
                if (apiName.endsWith("NotifyUrl") || apiName.endsWith("notifyUrl")) {
                    continue;
                }

                // 解析请求参数
                List<PropertyInfo> properties = extractRequestProperties(details);

                apis.add(new ApiInfo(path, method.toUpperCase(), summary, apiName, properties, description, details));
            }
        }

        return apis;
    }

    /**
     * 提取 API 名称
     */
    private static String extractApiName(String description, String path) {
        // 处理重复接口路径的情况：
        // 1. delSuffixStart 开头：/aggregate-pay/api/gateway/orderAndPay/delSuffixStart1
        // 2. (for-xxx) 括号：/aggregate-pay/api/gateway/orderAndPay(for-drop-dont-copy-me)
        // 这些情况下应该使用父级路径作为 API 名称

        // 先尝试从描述中提取接口名称
        String apiNameFromDesc = null;
        if (description != null) {
            if (description.contains("接口名称：")) {
                String parts = description.substring(description.indexOf("接口名称：") + 5);
                String apiName = parts.split("\\s+")[0];
                if (!apiName.isEmpty()) {
                    apiNameFromDesc = apiName;
                }
            } else if (description.contains("接口名称:")) {
                String parts = description.substring(description.indexOf("接口名称:") + 5);
                String apiName = parts.split("\\s+")[0];
                if (!apiName.isEmpty()) {
                    apiNameFromDesc = apiName;
                }
            }
        }

        // 检查路径是否包含重复标识
        String[] parts = path.split("/");
        String lastPart = parts.length > 0 ? parts[parts.length - 1] : "";

        // 如果路径包含重复标识，返回父级接口名称
        if (lastPart.startsWith("delSuffixStart") ||
            lastPart.matches("\\(for-[^)]*\\)") ||
            lastPart.matches(".*[Dd]ont[Cc]opy[Mm]e") ||
            lastPart.matches(".*[Cc]opy[Mm]e")) {

            // 查找父级接口名称
            for (int i = parts.length - 1; i >= 0; i--) {
                String part = parts[i];
                if (!part.startsWith("delSuffixStart") &&
                    !part.matches("\\(for-[^)]*\\)") &&
                    !part.matches(".*[Dd]ont[Cc]opy[Mm]e") &&
                    !part.matches(".*[Cc]opy[Mm]e") &&
                    !part.isEmpty() &&
                    !part.equals("aggregate-pay") &&
                    !part.equals("api") &&
                    !part.equals("gateway")) {
                    return part;
                }
            }
        }

        // 如果从描述中提取到了接口名称，优先使用
        if (apiNameFromDesc != null) {
            return apiNameFromDesc;
        }

        // 从路径生成 API 名称（去除括号内容）
        if (parts.length > 0) {
            lastPart = parts[parts.length - 1];
            lastPart = lastPart.replaceAll("\\([^)]*\\)", "");
            return lastPart;
        }

        return "unknownApi";
    }

    /**
     * 提取请求属性（只提取 data 字段内的属性），支持递归处理嵌套对象
     */
    private static List<PropertyInfo> extractRequestProperties(JSONObject details) {
        return extractPropertiesFromRequest(details.getJSONObject("requestBody"));
    }

    /**
     * 提取响应属性（只提取 data 字段内的属性），支持递归处理嵌套对象
     */
    private static List<PropertyInfo> extractResponseProperties(JSONObject details) {
        JSONObject responses = details.getJSONObject("responses");
        if (responses == null) {
            return new ArrayList<>();
        }
        JSONObject response200 = responses.getJSONObject("200");
        if (response200 == null) {
            return new ArrayList<>();
        }
        return extractPropertiesFromResponse(response200);
    }

    /**
     * 从请求体中提取属性
     */
    private static List<PropertyInfo> extractPropertiesFromRequest(JSONObject requestBody) {
        if (requestBody == null) {
            return new ArrayList<>();
        }
        JSONObject content = requestBody.getJSONObject("content");
        if (content == null) {
            return new ArrayList<>();
        }
        JSONObject schema = content.getJSONObject("application/json");
        if (schema == null) {
            return new ArrayList<>();
        }
        JSONObject schemaObj = schema.getJSONObject("schema");
        if (schemaObj == null) {
            return new ArrayList<>();
        }
        JSONObject props = schemaObj.getJSONObject("properties");
        if (props == null) {
            return new ArrayList<>();
        }
        JSONObject dataProp = props.getJSONObject("data");
        if (dataProp == null) {
            return new ArrayList<>();
        }
        return extractPropertiesFromData(dataProp);
    }

    /**
     * 从响应中提取属性
     */
    private static List<PropertyInfo> extractPropertiesFromResponse(JSONObject response) {
        JSONObject content = response.getJSONObject("content");
        if (content == null) {
            return new ArrayList<>();
        }
        JSONObject schema = content.getJSONObject("application/json");
        if (schema == null) {
            return new ArrayList<>();
        }
        JSONObject schemaObj = schema.getJSONObject("schema");
        if (schemaObj == null) {
            return new ArrayList<>();
        }
        JSONObject props = schemaObj.getJSONObject("properties");
        if (props == null) {
            return new ArrayList<>();
        }
        JSONObject dataProp = props.getJSONObject("data");
        if (dataProp == null) {
            return new ArrayList<>();
        }
        return extractPropertiesFromData(dataProp);
    }

    /**
     * 从 data 对象中提取属性
     */
    private static List<PropertyInfo> extractPropertiesFromData(JSONObject dataProp) {
        List<PropertyInfo> properties = new ArrayList<>();
        JSONObject dataProps = dataProp.getJSONObject("properties");
        if (dataProps == null) {
            return properties;
        }

        for (String propName : dataProps.keySet()) {
            JSONObject propDetails = dataProps.getJSONObject(propName);
            String type = propDetails.getString("type");
            String desc = propDetails.getString("description");
            // 去除字段名前后的空格
            propName = propName.trim();

            // 提取数组元素的类型
            if ("array".equals(type)) {
                JSONObject items = propDetails.getJSONObject("items");
                if (items != null) {
                    String itemType = items.getString("type");
                    // 检查是否有嵌套属性（用于生成嵌套类）
                    JSONObject itemProps = items.getJSONObject("properties");
                    if (itemProps != null) {
                        // 数组元素是嵌套对象，递归提取其属性
                        List<PropertyInfo> itemProperties = extractPropertiesFromJsonObject(itemProps);
                        properties.add(new PropertyInfo(propName, type, desc, itemProperties));
                        continue;
                    } else if (itemType != null) {
                        // 数组元素是基本类型（如 string, integer 等）
                        properties.add(new PropertyInfo(propName, type, desc, itemType));
                        continue;
                    }
                }
            }

            // 提取嵌套对象的属性
            if ("object".equals(type)) {
                JSONObject nestedProps = propDetails.getJSONObject("properties");
                if (nestedProps != null) {
                    // 嵌套对象，递归提取其属性
                    List<PropertyInfo> nestedProperties = extractPropertiesFromJsonObject(nestedProps);
                    properties.add(new PropertyInfo(propName, type, desc, nestedProperties));
                    continue;
                }
            }

            properties.add(new PropertyInfo(propName, type, desc));
        }

        return properties;
    }

    /**
     * 从 JSONObject 中递归提取属性列表
     */
    private static List<PropertyInfo> extractPropertiesFromJsonObject(JSONObject props) {
        List<PropertyInfo> properties = new ArrayList<>();

        for (String propName : props.keySet()) {
            JSONObject propDetails = props.getJSONObject(propName);
            String type = propDetails.getString("type");
            String desc = propDetails.getString("description");
            // 去除字段名前后的空格
            propName = propName.trim();

            // 提取数组元素的类型
            if ("array".equals(type)) {
                JSONObject items = propDetails.getJSONObject("items");
                if (items != null) {
                    String itemType = items.getString("type");
                    // 检查是否有嵌套属性（用于生成嵌套类）
                    JSONObject itemProps = items.getJSONObject("properties");
                    if (itemProps != null) {
                        // 数组元素是嵌套对象，递归提取其属性
                        List<PropertyInfo> itemProperties = extractPropertiesFromJsonObject(itemProps);
                        properties.add(new PropertyInfo(propName, type, desc, itemProperties));
                        continue;
                    } else if (itemType != null) {
                        // 数组元素是基本类型
                        properties.add(new PropertyInfo(propName, type, desc, itemType));
                        continue;
                    }
                }
            }

            // 提取嵌套对象的属性
            if ("object".equals(type)) {
                JSONObject nestedProps = propDetails.getJSONObject("properties");
                if (nestedProps != null) {
                    // 嵌套对象，递归提取其属性
                    List<PropertyInfo> nestedProperties = extractPropertiesFromJsonObject(nestedProps);
                    properties.add(new PropertyInfo(propName, type, desc, nestedProperties));
                    continue;
                }
            }

            properties.add(new PropertyInfo(propName, type, desc));
        }

        return properties;
    }

    /**
     * 生成请求类代码
     */
    private static String generateRequestClass(ApiInfo api) {
        StringBuilder code = new StringBuilder();
        String className = getRequestClassName(api.apiName);
        String respClassName = getResponseClassName(api.apiName);

        // 收集需要导入的类型
        Set<String> imports = new TreeSet<>();
        imports.add("java.io.Serializable");

        // 检查是否有 List 类型
        for (PropertyInfo prop : api.properties) {
            if ("array".equals(prop.type)) {
                imports.add("java.util.List");
                break;
            }
        }

        code.append("package ").append(BASE_PACKAGE).append(".req;\n");
        code.append("\n");
        code.append("import ").append(BASE_PACKAGE).append(".api.BaseRequest;\n");
        code.append("import ").append(BASE_PACKAGE).append(".resp.").append(respClassName).append(";\n");
        for (String imp : imports) {
            code.append("import ").append(imp).append(";\n");
        }
        code.append("\n");
        code.append("/**\n");
        code.append(" * ").append(api.summary).append("\n");
        if (api.description != null && !api.description.isEmpty()) {
            String desc = api.description.length() > 100 ? api.description.substring(0, 100) + "..." : api.description;
            code.append(" * ").append(desc).append("\n");
        }
        code.append(" *\n");
        code.append(" * API 路径: ").append(api.path).append("\n");
        code.append(" * 请求方法: ").append(api.method).append("\n");
        code.append(" **/\n");
        code.append("public class ").append(className).append(" extends BaseRequest<").append(respClassName).append("> implements Serializable {\n");
        code.append("\n");
        code.append("    private static final long serialVersionUID = 1L;\n");
        code.append("\n");

        // 生成属性
        for (PropertyInfo prop : api.properties) {
            String javaType;
            if (prop.hasNestedProperties()) {
                String nestedClassName = toPascalCase(prop.name);
                if ("array".equals(prop.type)) {
                    javaType = "List<" + nestedClassName + ">";
                } else {
                    javaType = nestedClassName;
                }
            } else if (prop.hasItemType()) {
                // 数组元素是基本类型
                String itemJavaType = mapTypeToJava(prop.itemType);
                javaType = "List<" + itemJavaType + ">";
            } else {
                javaType = mapTypeToJava(prop.type);
            }
            code.append("    /**\n");
            code.append("     * ").append(prop.description != null ? prop.description : "").append("\n");
            code.append("     */\n");
            // 字段名直接使用 API 文档中的原始名称
            code.append("    private ").append(javaType).append(" ").append(prop.name).append(";\n");
            code.append("\n");
        }

        // 生成 getter 和 setter
        for (PropertyInfo prop : api.properties) {
            String propNamePascal = toPascalCase(prop.name);
            String javaType;
            if (prop.hasNestedProperties()) {
                String nestedClassName = toPascalCase(prop.name);
                if ("array".equals(prop.type)) {
                    javaType = "List<" + nestedClassName + ">";
                } else {
                    javaType = nestedClassName;
                }
            } else if (prop.hasItemType()) {
                // 数组元素是基本类型
                String itemJavaType = mapTypeToJava(prop.itemType);
                javaType = "List<" + itemJavaType + ">";
            } else {
                javaType = mapTypeToJava(prop.type);
            }

            code.append("    public ").append(javaType).append(" get").append(propNamePascal).append("() {\n");
            code.append("        return ").append(prop.name).append(";\n");
            code.append("    }\n");
            code.append("\n");
            code.append("    public void set").append(propNamePascal).append("(").append(javaType).append(" ").append(prop.name).append(") {\n");
            code.append("        this.").append(prop.name).append(" = ").append(prop.name).append(";\n");
            code.append("    }\n");
            code.append("\n");
        }

        // 生成 getApiName 方法
        code.append("    @Override\n");
        code.append("    protected String getApiName() {\n");
        code.append("        return \"").append(api.apiName).append("\";\n");
        code.append("    }\n");

        // 收集所有嵌套类（扁平化结构）
        List<NestedClassInfo> nestedClasses = new ArrayList<>();
        collectAllNestedClasses(api.properties, nestedClasses);

        // 统一生成所有嵌套类（放在外层类的底部）
        for (NestedClassInfo nestedClass : nestedClasses) {
            code.append(generateSingleNestedClass(nestedClass.className, nestedClass.properties, nestedClass.isItemClass));
        }

        code.append("}\n");

        return code.toString();
    }

    /**
     * 嵌套类信息（用于收集所有嵌套类）
     */
    static class NestedClassInfo {
        String className;
        List<PropertyInfo> properties;
        boolean isItemClass;

        NestedClassInfo(String className, List<PropertyInfo> properties, boolean isItemClass) {
            this.className = className;
            this.properties = properties;
            this.isItemClass = isItemClass;
        }
    }

    /**
     * 递归收集所有嵌套类（扁平化结构）
     */
    private static void collectAllNestedClasses(List<PropertyInfo> properties, List<NestedClassInfo> collectedClasses) {
        for (PropertyInfo prop : properties) {
            if (prop.hasNestedProperties()) {
                String nestedClassName = toPascalCase(prop.name);
                // 添加当前嵌套类
                collectedClasses.add(new NestedClassInfo(nestedClassName, prop.nestedProperties, "array".equals(prop.type)));
                // 递归收集更深层的嵌套类
                collectAllNestedClasses(prop.nestedProperties, collectedClasses);
            }
        }
    }

    /**
     * 生成单个嵌套类代码（不递归生成内部嵌套类）
     */
    private static String generateSingleNestedClass(String className, List<PropertyInfo> properties, boolean isItemClass) {
        StringBuilder code = new StringBuilder();

        code.append("    /**\n");
        code.append("     * ").append(isItemClass ? "数组元素" : "嵌套对象").append("\n");
        code.append("     */\n");
        code.append("    public static final class ").append(className).append(" implements Serializable {\n");
        code.append("        private static final long serialVersionUID = 1L;\n");
        code.append("\n");

        // 生成属性
        for (PropertyInfo prop : properties) {
            String javaType;
            if (prop.hasNestedProperties()) {
                String nestedClassName = toPascalCase(prop.name);
                if ("array".equals(prop.type)) {
                    javaType = "List<" + nestedClassName + ">";
                } else {
                    javaType = nestedClassName;
                }
            } else if (prop.hasItemType()) {
                String itemJavaType = mapTypeToJava(prop.itemType);
                javaType = "List<" + itemJavaType + ">";
            } else {
                javaType = mapTypeToJava(prop.type);
            }
            code.append("        /**\n");
            code.append("         * ").append(prop.description != null ? prop.description : "").append("\n");
            code.append("         */\n");
            // 字段名直接使用 API 文档中的原始名称
            code.append("        private ").append(javaType).append(" ").append(prop.name).append(";\n");
            code.append("\n");
        }

        // 生成 getter 和 setter
        for (PropertyInfo prop : properties) {
            String propNamePascal = toPascalCase(prop.name);
            String javaType;
            if (prop.hasNestedProperties()) {
                String nestedClassName = toPascalCase(prop.name);
                if ("array".equals(prop.type)) {
                    javaType = "List<" + nestedClassName + ">";
                } else {
                    javaType = nestedClassName;
                }
            } else if (prop.hasItemType()) {
                String itemJavaType = mapTypeToJava(prop.itemType);
                javaType = "List<" + itemJavaType + ">";
            } else {
                javaType = mapTypeToJava(prop.type);
            }

            code.append("        public ").append(javaType).append(" get").append(propNamePascal).append("() {\n");
            code.append("            return ").append(prop.name).append(";\n");
            code.append("        }\n");
            code.append("\n");
            code.append("        public void set").append(propNamePascal).append("(").append(javaType).append(" ").append(prop.name).append(") {\n");
            code.append("            this.").append(prop.name).append(" = ").append(prop.name).append(";\n");
            code.append("        }\n");
            code.append("\n");
        }

        code.append("    }\n");
        code.append("\n");

        return code.toString();
    }

    /**
     * 生成响应类代码
     */
    private static String generateResponseClass(ApiInfo api) {
        StringBuilder code = new StringBuilder();
        String className = getResponseClassName(api.apiName);

        // 收集需要导入的类型
        Set<String> imports = new TreeSet<>();
        imports.add("java.io.Serializable");

        // 从 API 中提取响应字段
        List<PropertyInfo> responseProperties = extractResponseProperties(api.details);

        // 检查是否有 List 类型
        for (PropertyInfo prop : responseProperties) {
            if ("array".equals(prop.type)) {
                imports.add("java.util.List");
                break;
            }
        }

        code.append("package ").append(BASE_PACKAGE).append(".resp;\n");
        code.append("\n");
        for (String imp : imports) {
            code.append("import ").append(imp).append(";\n");
        }
        code.append("\n");
        code.append("/**\n");
        code.append(" * ").append(api.summary).append(" - 响应\n");
        code.append(" **/\n");
        code.append("public class ").append(className).append(" implements Serializable {\n");
        code.append("\n");
        code.append("    private static final long serialVersionUID = 1L;\n");
        code.append("\n");

        // 生成响应字段
        for (PropertyInfo prop : responseProperties) {
            String javaType;
            if (prop.hasNestedProperties()) {
                String nestedClassName = toPascalCase(prop.name);
                if ("array".equals(prop.type)) {
                    javaType = "List<" + nestedClassName + ">";
                } else {
                    javaType = nestedClassName;
                }
            } else if (prop.hasItemType()) {
                // 数组元素是基本类型
                String itemJavaType = mapTypeToJava(prop.itemType);
                javaType = "List<" + itemJavaType + ">";
            } else {
                javaType = mapTypeToJava(prop.type);
            }
            code.append("    /**\n");
            code.append("     * ").append(prop.description != null ? prop.description : "").append("\n");
            code.append("     */\n");
            // 字段名直接使用 API 文档中的原始名称
            code.append("    private ").append(javaType).append(" ").append(prop.name).append(";\n");
            code.append("\n");
        }

        // 生成 getter 和 setter
        for (PropertyInfo prop : responseProperties) {
            String propNamePascal = toPascalCase(prop.name);
            String javaType;
            if (prop.hasNestedProperties()) {
                String nestedClassName = toPascalCase(prop.name);
                if ("array".equals(prop.type)) {
                    javaType = "List<" + nestedClassName + ">";
                } else {
                    javaType = nestedClassName;
                }
            } else if (prop.hasItemType()) {
                // 数组元素是基本类型
                String itemJavaType = mapTypeToJava(prop.itemType);
                javaType = "List<" + itemJavaType + ">";
            } else {
                javaType = mapTypeToJava(prop.type);
            }

            code.append("    public ").append(javaType).append(" get").append(propNamePascal).append("() {\n");
            code.append("        return ").append(prop.name).append(";\n");
            code.append("    }\n");
            code.append("\n");
            code.append("    public void set").append(propNamePascal).append("(").append(javaType).append(" ").append(prop.name).append(") {\n");
            code.append("        this.").append(prop.name).append(" = ").append(prop.name).append(";\n");
            code.append("    }\n");
            code.append("\n");
        }

        // 收集所有嵌套类（扁平化结构）
        List<NestedClassInfo> nestedClasses = new ArrayList<>();
        collectAllNestedClasses(responseProperties, nestedClasses);

        // 统一生成所有嵌套类（放在外层类的底部）
        for (NestedClassInfo nestedClass : nestedClasses) {
            code.append(generateSingleNestedClass(nestedClass.className, nestedClass.properties, nestedClass.isItemClass));
        }

        code.append("}\n");

        return code.toString();
    }

    /**
     * 转换为驼峰命名（首字母小写）- 仅用于类名
     * 字段名直接使用 API 文档中的原始名称，不做转换
     */
    private static String toCamelCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        // 替换特殊字符为下划线
        text = text.replaceAll("[^a-zA-Z0-9]", "_");

        // 如果包含下划线，按驼峰处理
        if (text.contains("_")) {
            String[] parts = text.split("_");
            StringBuilder result = new StringBuilder(parts[0].toLowerCase());
            for (int i = 1; i < parts.length; i++) {
                if (!parts[i].isEmpty()) {
                    result.append(Character.toUpperCase(parts[i].charAt(0)));
                    if (parts[i].length() > 1) {
                        result.append(parts[i].substring(1).toLowerCase());
                    }
                }
            }
            return result.toString();
        }

        // 不包含下划线，直接返回小写首字母
        if (Character.isUpperCase(text.charAt(0))) {
            return Character.toLowerCase(text.charAt(0)) + text.substring(1);
        }
        return text;
    }

    /**
     * 转换为帕斯卡命名（首字母大写）- 保持其他字母不变
     */
    private static String toPascalCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        // 只将首字母大写，保持其他字母不变
        if (Character.isLowerCase(text.charAt(0))) {
            return Character.toUpperCase(text.charAt(0)) + text.substring(1);
        }
        return text;
    }

    /**
     * 生成请求类名（处理 API 名称已包含 Request/Response 后缀的情况）
     */
    private static String getRequestClassName(String apiName) {
        String className = toPascalCase(apiName);
        className = className.replaceAll("[^\\w]", "_");

        // 如果已经以 Request 或 Response 结尾，去掉它
        if (className.endsWith("Request")) {
            className = className.substring(0, className.length() - 7);
        } else if (className.endsWith("Response")) {
            className = className.substring(0, className.length() - 8);
        }

        return className + "Request";
    }

    /**
     * 生成响应类名（处理 API 名称已包含 Request/Response 后缀的情况）
     */
    private static String getResponseClassName(String apiName) {
        String className = toPascalCase(apiName);
        className = className.replaceAll("[^\\w]", "_");

        // 如果已经以 Request 或 Response 结尾，去掉它
        if (className.endsWith("Request")) {
            className = className.substring(0, className.length() - 7);
        } else if (className.endsWith("Response")) {
            className = className.substring(0, className.length() - 8);
        }

        return className + "Response";
    }

    /**
     * 映射 JSON 类型到 Java 类型
     */
    private static String mapTypeToJava(String jsonType) {
        if (jsonType == null) {
            return "String";
        }
        switch (jsonType) {
            case "string":
                return "String";
            case "integer":
                return "Integer";
            case "number":
                return "Long";
            case "boolean":
                return "Boolean";
            case "array":
                return "List";
            case "object":
                return "Object";
            default:
                return "String";
        }
    }

    /**
     * 读取文件内容
     */
    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    /**
     * 写入文件（确保文件名使用帕斯卡命名）
     */
    private static void writeFile(Path filePath, String content) throws IOException {
        Files.createDirectories(filePath.getParent());

        // 确保文件名使用帕斯卡命名
        String fileName = filePath.getFileName().toString();
        String className = fileName.replace(".java", "");
        String pascalClassName = toPascalCase(className);

        Path newFilePath = filePath.resolveSibling(pascalClassName + ".java");

        try (BufferedWriter writer = Files.newBufferedWriter(newFilePath, StandardCharsets.UTF_8)) {
            writer.write(content);
        }
        System.out.println("生成文件: " + newFilePath);
    }

    /**
     * 获取已存在的请求类
     */
    private static Set<String> getExistingRequestClasses() {
        Set<String> existingClasses = new HashSet<>();
        File dir = new File(REQ_OUTPUT_DIR);
        if (dir.exists()) {
            File[] files = dir.listFiles((d, name) -> name.endsWith("Request.java"));
            if (files != null) {
                for (File file : files) {
                    String className = file.getName().replace(".java", "");
                    existingClasses.add(className);
                }
            }
        }
        return existingClasses;
    }

    /**
     * 获取已存在的响应类
     */
    private static Set<String> getExistingResponseClasses() {
        Set<String> existingClasses = new HashSet<>();
        File dir = new File(RESP_OUTPUT_DIR);
        if (dir.exists()) {
            File[] files = dir.listFiles((d, name) -> name.endsWith("Response.java"));
            if (files != null) {
                for (File file : files) {
                    String className = file.getName().replace(".java", "");
                    existingClasses.add(className);
                }
            }
        }
        return existingClasses;
    }

    /**
     * API 信息
     */
    static class ApiInfo {
        String path;
        String method;
        String summary;
        String apiName;
        List<PropertyInfo> properties;
        String description;
        JSONObject details;  // 保存完整的 details 对象，用于提取响应字段

        ApiInfo(String path, String method, String summary, String apiName, List<PropertyInfo> properties, String description, JSONObject details) {
            this.path = path;
            this.method = method;
            this.summary = summary;
            this.apiName = apiName;
            this.properties = properties;
            this.description = description;
            this.details = details;
        }
    }

    /**
     * 属性信息
     */
    static class PropertyInfo {
        String name;
        String type;
        String description;
        // 嵌套属性（用于 object 或 array 的 item 类型）
        List<PropertyInfo> nestedProperties;
        // 数组元素的基本类型（当数组元素不是嵌套对象时使用，如 String, Integer 等）
        String itemType;

        PropertyInfo(String name, String type, String description) {
            this.name = name;
            this.type = type;
            this.description = description;
        }

        PropertyInfo(String name, String type, String description, List<PropertyInfo> nestedProperties) {
            this.name = name;
            this.type = type;
            this.description = description;
            this.nestedProperties = nestedProperties;
        }

        PropertyInfo(String name, String type, String description, String itemType) {
            this.name = name;
            this.type = type;
            this.description = description;
            this.itemType = itemType;
        }

        boolean hasNestedProperties() {
            return nestedProperties != null && !nestedProperties.isEmpty();
        }

        boolean hasItemType() {
            return itemType != null && !itemType.isEmpty();
        }
    }
}
