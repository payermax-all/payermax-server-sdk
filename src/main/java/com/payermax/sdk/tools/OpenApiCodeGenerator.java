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

    // ==================== 常量定义 ====================
    private static final String PROJECT_ROOT = System.getProperty("user.dir");
    private static final String OPENAPI_FILE = PROJECT_ROOT + "/api.json";
    private static final String REQ_OUTPUT_DIR = PROJECT_ROOT + "/src/main/java/com/payermax/sdk/req";
    private static final String RESP_OUTPUT_DIR = PROJECT_ROOT + "/src/main/java/com/payermax/sdk/resp";
    private static final String BASE_PACKAGE = "com.payermax.sdk";

    // JSON 路径常量
    private static final String JSON_PATH_RESPONSES = "responses";
    private static final String JSON_RESPONSE_200 = "200";
    private static final String JSON_CONTENT = "content";
    private static final String JSON_APPLICATION_JSON = "application/json";
    private static final String JSON_SCHEMA = "schema";
    private static final String JSON_PROPERTIES = "properties";
    private static final String JSON_DATA = "data";
    private static final String JSON_REQUEST_BODY = "requestBody";
    private static final String JSON_ITEMS = "items";
    private static final String JSON_TYPE = "type";
    private static final String JSON_DESCRIPTION = "description";

    // 类名后缀常量
    private static final String SUFFIX_REQUEST = "Request";
    private static final String SUFFIX_RESPONSE = "Response";
    private static final int REQUEST_SUFFIX_LENGTH = 7;
    private static final int RESPONSE_SUFFIX_LENGTH = 8;

    // 其他常量
    private static final int MAX_DESCRIPTION_LENGTH = 100;
    private static final String INTERFACE_NAME_CN = "接口名称：";
    private static final String INTERFACE_NAME_EN = "接口名称:";
    private static final int INTERFACE_NAME_PREFIX_LENGTH = 5;
    private static final String FILE_SUFFIX_REQUEST = "Request.java";
    private static final String FILE_SUFFIX_RESPONSE = "Response.java";
    private static final String FILE_EXT_JAVA = ".java";
    private static final String TYPE_ARRAY = "array";
    private static final String TYPE_STRING = "String";
    private static final String IMPORT_STATEMENT = "import ";
    private static final String METHOD_CLOSING_BRACE = "    }\n\n";

    // HTTP 方法集合
    private static final Set<String> HTTP_METHODS = new HashSet<>(
        Arrays.asList("get", "post", "put", "delete", "patch")
    );

    // 路径过滤常量
    private static final String PATH_AGGREGATE_PAY = "aggregate-pay";
    private static final String PATH_API = "api";
    private static final String PATH_GATEWAY = "gateway";

    public static void main(String[] args) {
        try {
            System.out.println("开始解析 OpenAPI 文档...");
            System.out.println("文件路径: " + OPENAPI_FILE);

            String content = readFile(OPENAPI_FILE);
            JSONObject openapi = JSON.parseObject(content);

            List<ApiInfo> apis = parseApis(openapi);
            System.out.println("共解析到 " + apis.size() + " 个 API 接口");

            // 获取已存在的类
            Set<String> existingReqClasses = getExistingClasses(REQ_OUTPUT_DIR, FILE_SUFFIX_REQUEST);
            Set<String> existingRespClasses = getExistingClasses(RESP_OUTPUT_DIR, FILE_SUFFIX_RESPONSE);
            System.out.println("已存在 " + existingReqClasses.size() + " 个请求类，" + existingRespClasses.size() + " 个响应类（将被覆盖）");

            // 生成代码
            generateClasses(apis);

            System.out.println("\n完成！共生成 " + apis.size() + " 个新的请求类和响应类");

        } catch (Exception e) {
            System.err.println("生成失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 生成所有请求类和响应类
     */
    private static void generateClasses(List<ApiInfo> apis) throws IOException {
        for (ApiInfo api : apis) {
            String reqCode = generateRequestClass(api);
            String respCode = generateResponseClass(api);

            String reqClassName = getClassName(api.apiName, SUFFIX_REQUEST);
            String respClassName = getClassName(api.apiName, SUFFIX_RESPONSE);

            writeFile(Paths.get(REQ_OUTPUT_DIR, reqClassName + FILE_EXT_JAVA), reqCode);
            writeFile(Paths.get(RESP_OUTPUT_DIR, respClassName + FILE_EXT_JAVA), respCode);
        }
    }

    /**
     * 解析 API 接口信息
     */
    private static List<ApiInfo> parseApis(JSONObject openapi) {
        List<ApiInfo> apis = new ArrayList<>();
        JSONObject paths = openapi.getJSONObject(JSON_PROPERTIES);

        if (paths == null) {
            return apis;
        }

        for (String path : paths.keySet()) {
            JSONObject methods = paths.getJSONObject(path);
            for (String method : methods.keySet()) {
                // 跳过非 HTTP 方法
                if (!HTTP_METHODS.contains(method.toLowerCase())) {
                    continue;
                }

                JSONObject details = methods.getJSONObject(method);
                String summary = details.getString("summary");
                String description = details.getString(JSON_DESCRIPTION);
                String apiName = extractApiName(description, path);

                List<PropertyInfo> properties = extractRequestProperties(details);
                // 只添加符合条件的 API
                if (shouldIncludeApi(apiName)) {
                    apis.add(new ApiInfo(path, method.toUpperCase(), summary, apiName, properties, description, details));
                }
            }
        }

        return apis;
    }

    /**
     * 判断是否应该包含该 API（过滤回调通知类接口）
     */
    private static boolean shouldIncludeApi(String apiName) {
        return !apiName.endsWith("NotifyUrl") && !apiName.endsWith("notifyUrl");
    }

    /**
     * 提取 API 名称
     */
    private static String extractApiName(String description, String path) {
        // 先尝试从描述中提取接口名称
        String apiNameFromDesc = extractApiNameFromDescription(description);
        if (apiNameFromDesc != null) {
            return apiNameFromDesc;
        }

        // 从路径生成 API 名称
        return extractApiNameFromPath(path);
    }

    /**
     * 从描述中提取 API 名称
     */
    private static String extractApiNameFromDescription(String description) {
        if (description == null) {
            return null;
        }

        int nameIndex;
        if (description.contains(INTERFACE_NAME_CN)) {
            nameIndex = description.indexOf(INTERFACE_NAME_CN) + INTERFACE_NAME_PREFIX_LENGTH;
        } else if (description.contains(INTERFACE_NAME_EN)) {
            nameIndex = description.indexOf(INTERFACE_NAME_EN) + INTERFACE_NAME_PREFIX_LENGTH;
        } else {
            return null;
        }

        String parts = description.substring(nameIndex);
        String apiName = parts.split("\\s+")[0];
        return apiName.isEmpty() ? null : apiName;
    }

    /**
     * 从路径中提取 API 名称
     */
    private static String extractApiNameFromPath(String path) {
        String[] parts = path.split("/");
        String lastPart = parts.length > 0 ? parts[parts.length - 1] : "";

        // 检查是否是重复标识路径
        if (isDuplicatePath(lastPart)) {
            // 查找父级接口名称
            for (int i = parts.length - 1; i >= 0; i--) {
                String part = parts[i];
                if (!isDuplicatePath(part) && !part.isEmpty() && !isSystemPath(part)) {
                    return part;
                }
            }
        }

        // 去除括号内容
        return lastPart.replaceAll("\\([^)]*\\)", "");
    }

    /**
     * 检查是否是重复标识路径
     */
    private static boolean isDuplicatePath(String part) {
        return part.startsWith("delSuffixStart")
            || part.matches("\\(for-[^)]*\\)")
            || part.matches(".*[Dd]ont[Cc]opy[Mm]e")
            || part.matches(".*[Cc]opy[Mm]e");
    }

    /**
     * 检查是否是系统路径
     */
    private static boolean isSystemPath(String part) {
        return PATH_AGGREGATE_PAY.equals(part)
            || PATH_API.equals(part)
            || PATH_GATEWAY.equals(part);
    }

    /**
     * 提取请求属性
     */
    private static List<PropertyInfo> extractRequestProperties(JSONObject details) {
        return extractProperties(details.getJSONObject(JSON_REQUEST_BODY));
    }

    /**
     * 提取响应属性
     */
    private static List<PropertyInfo> extractResponseProperties(JSONObject details) {
        JSONObject responses = details.getJSONObject(JSON_PATH_RESPONSES);
        if (responses == null) {
            return new ArrayList<>();
        }
        JSONObject response200 = responses.getJSONObject(JSON_RESPONSE_200);
        if (response200 == null) {
            return new ArrayList<>();
        }
        return extractProperties(response200);
    }

    /**
     * 从请求/响应体中提取属性（统一处理）
     */
    private static List<PropertyInfo> extractProperties(JSONObject requestBody) {
        if (requestBody == null) {
            return new ArrayList<>();
        }

        JSONObject content = requestBody.getJSONObject(JSON_CONTENT);
        if (content == null) {
            return new ArrayList<>();
        }

        JSONObject schema = content.getJSONObject(JSON_APPLICATION_JSON);
        if (schema == null) {
            return new ArrayList<>();
        }

        JSONObject schemaObj = schema.getJSONObject(JSON_SCHEMA);
        if (schemaObj == null) {
            return new ArrayList<>();
        }

        JSONObject props = schemaObj.getJSONObject(JSON_PROPERTIES);
        if (props == null) {
            return new ArrayList<>();
        }

        JSONObject dataProp = props.getJSONObject(JSON_DATA);
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
        JSONObject dataProps = dataProp.getJSONObject(JSON_PROPERTIES);
        if (dataProps == null) {
            return properties;
        }

        for (String propName : dataProps.keySet()) {
            JSONObject propDetails = dataProps.getJSONObject(propName);
            String type = propDetails.getString(JSON_TYPE);
            String desc = propDetails.getString(JSON_DESCRIPTION);
            propName = propName.trim();

            PropertyInfo prop = createPropertyInfo(propName, type, desc, propDetails);
            properties.add(prop);
        }

        return properties;
    }

    /**
     * 创建属性信息对象
     */
    private static PropertyInfo createPropertyInfo(String name, String type, String desc, JSONObject propDetails) {
        // 处理数组类型
        if (TYPE_ARRAY.equals(type)) {
            return createArrayPropertyInfo(name, type, desc, propDetails);
        }

        // 处理对象类型
        if ("object".equals(type)) {
            return createObjectPropertyInfo(name, type, desc, propDetails);
        }

        // 基本类型
        return new PropertyInfo(name, type, desc);
    }

    /**
     * 创建数组类型属性信息
     */
    private static PropertyInfo createArrayPropertyInfo(String name, String type, String desc, JSONObject propDetails) {
        JSONObject items = propDetails.getJSONObject(JSON_ITEMS);
        if (items == null) {
            return new PropertyInfo(name, type, desc);
        }

        String itemType = items.getString(JSON_TYPE);
        JSONObject itemProps = items.getJSONObject(JSON_PROPERTIES);

        if (itemProps != null) {
            // 数组元素是嵌套对象
            List<PropertyInfo> itemProperties = extractPropertiesFromJsonObject(itemProps);
            return new PropertyInfo(name, type, desc, itemProperties);
        } else if (itemType != null) {
            // 数组元素是基本类型
            return new PropertyInfo(name, type, desc, itemType);
        }

        return new PropertyInfo(name, type, desc);
    }

    /**
     * 创建对象类型属性信息
     */
    private static PropertyInfo createObjectPropertyInfo(String name, String type, String desc, JSONObject propDetails) {
        JSONObject nestedProps = propDetails.getJSONObject(JSON_PROPERTIES);
        if (nestedProps != null) {
            List<PropertyInfo> nestedProperties = extractPropertiesFromJsonObject(nestedProps);
            return new PropertyInfo(name, type, desc, nestedProperties);
        }
        return new PropertyInfo(name, type, desc);
    }

    /**
     * 从 JSONObject 中递归提取属性列表
     */
    private static List<PropertyInfo> extractPropertiesFromJsonObject(JSONObject props) {
        List<PropertyInfo> properties = new ArrayList<>();

        for (String propName : props.keySet()) {
            JSONObject propDetails = props.getJSONObject(propName);
            String type = propDetails.getString(JSON_TYPE);
            String desc = propDetails.getString(JSON_DESCRIPTION);
            propName = propName.trim();

            PropertyInfo prop = createPropertyInfo(propName, type, desc, propDetails);
            if (prop != null) {
                properties.add(prop);
            }
        }

        return properties;
    }

    /**
     * 转义 HTML 特殊字符（用于 Javadoc 注释）
     */
    private static String escapeHtml(String text) {
        if (text == null) {
            return null;
        }

        // 处理 Markdown 链接
        text = processMarkdownLinks(text);

        // 转义 HTML 特殊字符
        return escapeHtmlEntities(text);
    }

    /**
     * 处理 Markdown 链接格式
     */
    private static String processMarkdownLinks(String text) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < text.length()) {
            char c = text.charAt(i);

            // 尝试处理链接（带书名号或普通链接）
            int processedLength = tryProcessLink(text, i, c, result);
            if (processedLength > 0) {
                i += processedLength;
            } else {
                result.append(c);
                i++;
            }
        }

        return result.toString();
    }

    /**
     * 尝试处理链接格式
     * @return 处理的字符长度，0 表示未处理
     */
    private static int tryProcessLink(String text, int start, char firstChar, StringBuilder result) {
        // 检测带书名号的 Markdown 链接：【[文本](url)】
        if (firstChar == '【' && hasLeftBracketAt(text, start + 1)) {
            return processBracketedLink(text, start, result);
        }

        // 检测普通 Markdown 链接：[文本](url)
        if (firstChar == '[') {
            return processNormalLink(text, start, result);
        }

        return 0;
    }

    /**
     * 处理带书名号的链接：【[文本](url)】
     * @return 处理的字符长度，0 表示未处理
     */
    private static int processBracketedLink(String text, int start, StringBuilder result) {
        int linkEnd = text.indexOf("】", start + 2);
        if (linkEnd <= 0) {
            return 0;
        }

        int urlStart = text.indexOf("](", start + 2);
        if (urlStart <= 0 || urlStart >= linkEnd) {
            return 0;
        }

        int urlEnd = text.indexOf(')', urlStart + 2);
        if (urlEnd <= 0 || urlEnd >= linkEnd) {
            return 0;
        }

        // 提取链接文本：从 【[ 之后到 ]( 之前
        result.append(text.substring(start + 2, urlStart));
        return linkEnd + 1 - start;
    }

    /**
     * 处理普通链接：[文本](url)
     * @return 处理的字符长度，0 表示未处理
     */
    private static int processNormalLink(String text, int start, StringBuilder result) {
        int urlStart = text.indexOf("](", start + 1);
        if (urlStart <= 0) {
            return 0;
        }

        int urlEnd = text.indexOf(')', urlStart + 2);
        if (urlEnd <= 0) {
            return 0;
        }

        String linkText = text.substring(start + 1, urlStart);
        String url = text.substring(urlStart + 2, urlEnd);
        result.append(linkText).append(" (").append(url).append(")");
        return urlEnd + 1 - start;
    }

    /**
     * 检查指定位置是否有左括号
     */
    private static boolean hasLeftBracketAt(String text, int pos) {
        return pos < text.length() && text.charAt(pos) == '[';
    }

    /**
     * 转义 HTML 实体
     */
    private static String escapeHtmlEntities(String text) {
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;");
    }

    /**
     * 生成请求类代码
     */
    private static String generateRequestClass(ApiInfo api) {
        StringBuilder code = new StringBuilder();
        String className = getClassName(api.apiName, SUFFIX_REQUEST);
        String respClassName = getClassName(api.apiName, SUFFIX_RESPONSE);

        // 收集需要导入的类型
        Set<String> imports = collectImports(api.properties);

        // 生成包声明和导入
        code.append("package ").append(BASE_PACKAGE).append(".req;\n\n");
        code.append(IMPORT_STATEMENT).append(BASE_PACKAGE).append(".api.BaseRequest;\n");
        code.append(IMPORT_STATEMENT).append(BASE_PACKAGE).append(".resp.").append(respClassName).append(";\n");
        for (String imp : imports) {
            code.append(IMPORT_STATEMENT).append(imp).append(";\n");
        }
        code.append("\n");

        // 生成类注释
        generateClassComment(code, api, false);

        // 生成类声明
        code.append("public class ").append(className).append(" extends BaseRequest<").append(respClassName)
            .append("> implements Serializable {\n\n");
        code.append("    private static final long serialVersionUID = 1L;\n\n");

        // 生成属性
        generateFields(code, api.properties);

        // 生成 getter/setter
        generateAccessors(code, api.properties);

        // 生成 getApiName 方法
        code.append("    @Override\n");
        code.append("    protected String getApiName() {\n");
        code.append("        return \"").append(api.apiName).append("\";\n");
        code.append("    }\n");

        // 生成嵌套类
        generateNestedClasses(code, api.properties);

        code.append("}\n");
        return code.toString();
    }

    /**
     * 生成响应类代码
     */
    private static String generateResponseClass(ApiInfo api) {
        StringBuilder code = new StringBuilder();
        String className = getClassName(api.apiName, SUFFIX_RESPONSE);

        List<PropertyInfo> responseProperties = extractResponseProperties(api.details);
        Set<String> imports = collectImports(responseProperties);

        code.append("package ").append(BASE_PACKAGE).append(".resp;\n\n");
        for (String imp : imports) {
            code.append(IMPORT_STATEMENT).append(imp).append(";\n");
        }
        code.append("\n");

        code.append("/**\n");
        code.append(" * ").append(escapeHtml(api.summary)).append(" - 响应\n");
        code.append(" **/\n");
        code.append("public class ").append(className).append(" implements Serializable {\n\n");
        code.append("    private static final long serialVersionUID = 1L;\n\n");

        generateFields(code, responseProperties);
        generateAccessors(code, responseProperties);
        generateNestedClasses(code, responseProperties);

        code.append("}\n");
        return code.toString();
    }

    /**
     * 收集需要导入的类型
     */
    private static Set<String> collectImports(List<PropertyInfo> properties) {
        Set<String> imports = new TreeSet<>();
        imports.add("java.io.Serializable");

        for (PropertyInfo prop : properties) {
            if (TYPE_ARRAY.equals(prop.type)) {
                imports.add("java.util.List");
                break;
            }
        }

        return imports;
    }

    /**
     * 生成类注释
     */
    private static void generateClassComment(StringBuilder code, ApiInfo api, boolean isResponse) {
        code.append("/**\n");
        code.append(" * ").append(escapeHtml(api.summary)).append("\n");
        if (api.description != null && !api.description.isEmpty()) {
            String desc = api.description.length() > MAX_DESCRIPTION_LENGTH
                ? api.description.substring(0, MAX_DESCRIPTION_LENGTH) + "..."
                : api.description;
            code.append(" * ").append(escapeHtml(desc)).append("\n");
        }
        if (!isResponse) {
            code.append(" *\n");
            code.append(" * API 路径: ").append(escapeHtml(api.path)).append("\n");
            code.append(" * 请求方法: ").append(api.method).append("\n");
        }
        code.append(" **/\n");
    }

    /**
     * 生成字段
     */
    private static void generateFields(StringBuilder code, List<PropertyInfo> properties) {
        for (PropertyInfo prop : properties) {
            String javaType = getJavaType(prop);
            code.append("    /**\n");
            code.append("     * ").append(prop.description != null ? escapeHtml(prop.description) : "").append("\n");
            code.append("     */\n");
            code.append("    private ").append(javaType).append(" ").append(prop.name).append(";\n\n");
        }
    }

    /**
     * 生成 getter/setter
     */
    private static void generateAccessors(StringBuilder code, List<PropertyInfo> properties) {
        for (PropertyInfo prop : properties) {
            String propNamePascal = toPascalCase(prop.name);
            String javaType = getJavaType(prop);

            code.append("    public ").append(javaType).append(" get").append(propNamePascal).append("() {\n");
            code.append("        return ").append(prop.name).append(";\n");
            code.append(METHOD_CLOSING_BRACE);

            code.append("    public void set").append(propNamePascal).append("(").append(javaType).append(" ")
                .append(prop.name).append(") {\n");
            code.append("        this.").append(prop.name).append(" = ").append(prop.name).append(";\n");
            code.append(METHOD_CLOSING_BRACE);
        }
    }

    /**
     * 生成嵌套类
     */
    private static void generateNestedClasses(StringBuilder code, List<PropertyInfo> properties) {
        List<NestedClassInfo> nestedClasses = new ArrayList<>();
        collectAllNestedClasses(properties, nestedClasses);

        for (NestedClassInfo nestedClass : nestedClasses) {
            code.append(generateSingleNestedClass(nestedClass));
        }
    }

    /**
     * 获取属性的 Java 类型
     */
    private static String getJavaType(PropertyInfo prop) {
        if (prop.hasNestedProperties()) {
            String nestedClassName = toPascalCase(prop.name);
            return TYPE_ARRAY.equals(prop.type) ? "List<" + nestedClassName + ">" : nestedClassName;
        } else if (prop.hasItemType()) {
            String itemJavaType = mapTypeToJava(prop.itemType);
            return "List<" + itemJavaType + ">";
        } else {
            return mapTypeToJava(prop.type);
        }
    }

    /**
     * 嵌套类信息
     */
    private static class NestedClassInfo {
        private final String className;
        private final List<PropertyInfo> properties;
        private final boolean isItemClass;

        NestedClassInfo(String className, List<PropertyInfo> properties, boolean isItemClass) {
            this.className = className;
            this.properties = properties;
            this.isItemClass = isItemClass;
        }
    }

    /**
     * 递归收集所有嵌套类
     */
    private static void collectAllNestedClasses(List<PropertyInfo> properties, List<NestedClassInfo> collectedClasses) {
        Map<String, NestedClassInfo> classMap = new LinkedHashMap<>();
        collectNestedClassesToMap(properties, classMap);
        collectedClasses.addAll(classMap.values());
    }

    /**
     * 递归收集所有嵌套类到 Map 中（按类名合并）
     */
    private static void collectNestedClassesToMap(List<PropertyInfo> properties, Map<String, NestedClassInfo> classMap) {
        for (PropertyInfo prop : properties) {
            if (prop.hasNestedProperties()) {
                String nestedClassName = toPascalCase(prop.name);
                boolean isItemClass = TYPE_ARRAY.equals(prop.type);

                NestedClassInfo existing = classMap.get(nestedClassName);
                if (existing != null) {
                    mergeProperties(existing.properties, prop.nestedProperties);
                } else {
                    classMap.put(nestedClassName, new NestedClassInfo(nestedClassName, prop.nestedProperties, isItemClass));
                }

                collectNestedClassesToMap(prop.nestedProperties, classMap);
            }
        }
    }

    /**
     * 合并属性列表
     */
    private static void mergeProperties(List<PropertyInfo> target, List<PropertyInfo> source) {
        Map<String, PropertyInfo> propMap = new LinkedHashMap<>();
        for (PropertyInfo prop : target) {
            propMap.put(prop.name, prop);
        }
        for (PropertyInfo prop : source) {
            propMap.putIfAbsent(prop.name, prop);
        }
        target.clear();
        target.addAll(propMap.values());
    }

    /**
     * 生成单个嵌套类代码
     */
    private static String generateSingleNestedClass(NestedClassInfo nestedClass) {
        StringBuilder code = new StringBuilder();

        code.append("    /**\n");
        code.append("     * ").append(nestedClass.isItemClass ? "数组元素" : "嵌套对象").append("\n");
        code.append("     */\n");
        code.append("    public static final class ").append(nestedClass.className).append(" implements Serializable {\n");
        code.append("        private static final long serialVersionUID = 1L;\n\n");

        generateFields(code, nestedClass.properties);
        generateAccessors(code, nestedClass.properties);

        code.append(METHOD_CLOSING_BRACE);  // 嵌套类闭合括号
        return code.toString();
    }

    /**
     * 转换为帕斯卡命名（首字母大写）
     */
    private static String toPascalCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        if (Character.isLowerCase(text.charAt(0))) {
            return Character.toUpperCase(text.charAt(0)) + text.substring(1);
        }
        return text;
    }

    /**
     * 生成类名（统一处理请求类和响应类）
     */
    private static String getClassName(String apiName, String suffix) {
        // 处理 null 输入
        if (apiName == null) {
            return "Unknown" + suffix;
        }

        String className = toPascalCase(apiName);
        className = className.replaceAll("[^\\w]", "_");

        // 去除已存在的后缀
        if (className.endsWith(SUFFIX_REQUEST)) {
            className = className.substring(0, className.length() - REQUEST_SUFFIX_LENGTH);
        } else if (className.endsWith(SUFFIX_RESPONSE)) {
            className = className.substring(0, className.length() - RESPONSE_SUFFIX_LENGTH);
        }

        return className + suffix;
    }

    /**
     * 映射 JSON 类型到 Java 类型
     */
    private static String mapTypeToJava(String jsonType) {
        if (jsonType == null) {
            return TYPE_STRING;
        }

        switch (jsonType) {
            case "string":
                return TYPE_STRING;
            case "integer":
                return "Integer";
            case "number":
                return "Long";
            case "boolean":
                return "Boolean";
            case TYPE_ARRAY:
                return "List";
            case "object":
                return "Object";
            default:
                return TYPE_STRING;
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
     * 写入文件
     */
    private static void writeFile(Path filePath, String content) throws IOException {
        Files.createDirectories(filePath.getParent());

        String fileName = filePath.getFileName().toString();
        String className = fileName.replace(FILE_EXT_JAVA, "");
        String pascalClassName = toPascalCase(className);

        Path newFilePath = filePath.resolveSibling(pascalClassName + FILE_EXT_JAVA);

        try (BufferedWriter writer = Files.newBufferedWriter(newFilePath, StandardCharsets.UTF_8)) {
            writer.write(content);
        }
        System.out.println("生成文件: " + newFilePath);
    }

    /**
     * 获取已存在的类（统一处理请求类和响应类）
     */
    private static Set<String> getExistingClasses(String dirPath, String fileSuffix) {
        Set<String> existingClasses = new HashSet<>();
        File dir = new File(dirPath);
        if (dir.exists()) {
            File[] files = dir.listFiles((d, name) -> name.endsWith(fileSuffix));
            if (files != null) {
                for (File file : files) {
                    String className = file.getName().replace(FILE_EXT_JAVA, "");
                    existingClasses.add(className);
                }
            }
        }
        return existingClasses;
    }

    /**
     * API 信息
     */
    private static class ApiInfo {
        private final String path;
        private final String method;
        private final String summary;
        private final String apiName;
        private final List<PropertyInfo> properties;
        private final String description;
        private final JSONObject details;

        ApiInfo(String path, String method, String summary, String apiName,
                List<PropertyInfo> properties, String description, JSONObject details) {
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
    private static class PropertyInfo {
        private final String name;
        private final String type;
        private final String description;
        private final List<PropertyInfo> nestedProperties;
        private final String itemType;

        PropertyInfo(String name, String type, String description) {
            this(name, type, description, null, null);
        }

        PropertyInfo(String name, String type, String description, List<PropertyInfo> nestedProperties) {
            this(name, type, description, nestedProperties, null);
        }

        PropertyInfo(String name, String type, String description, String itemType) {
            this(name, type, description, null, itemType);
        }

        private PropertyInfo(String name, String type, String description,
                           List<PropertyInfo> nestedProperties, String itemType) {
            this.name = name;
            this.type = type;
            this.description = description;
            this.nestedProperties = nestedProperties;
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
