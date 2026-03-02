# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 项目概述

这是 **PayerMax Server SDK**，一个用于商户服务器端集成 PayerMax 支付服务的 Java SDK。支持交易订单、代付、退款、查询等多种支付场景。

## 常用命令

### 构建
```bash
mvn clean compile
```

### 运行测试
```bash
# 运行所有测试
mvn test

# 运行指定测试类
mvn test -Dtest=SdkTest
```

### 打包部署
```bash
# 打包（跳过测试和 GPG 签名，用于本地开发）
mvn clean package -DskipTests -Dgpg.skip=true

# 部署到 Maven Central（需要 GPG 签名）
mvn clean deploy -Dgpg.passphrase=<your-passphrase>
```

## 架构概览

### 核心设计模式

1. **单例模式**：`DefaultPayermaxClient` 采用单例模式，通过 `getInstance()` 获取实例

2. **Builder 模式**：`MerchantConfig` 使用 Builder 模式构建配置对象

3. **模板方法模式**：`BaseRequest<RESP>` 抽象基类定义了请求发送的模板方法，子类只需实现 `getApiName()`

### 层次结构

```
client/          # 客户端接口层
  ├── PayermaxClient              # 客户端接口
  └── DefaultPayermaxClient       # 默认实现（单例）

config/          # 配置管理层
  ├── MerchantConfig              # 单个商户配置
  └── GlobalMerchantConfig        # 全局配置管理（支持多商户）

api/             # 请求基类
  └── BaseRequest<RESP>           # 所有请求的抽象基类

req/             # 具体请求对象（继承 BaseRequest）
resp/            # 响应对象

domain/          # 领域模型
  ├── GatewayRequest              # 网关请求包装
  └── GatewayResult<T>            # 网关结果包装
```

### 多商户支持

SDK 支持两种商户配置模式：

1. **单商户模式**：通过 `GlobalMerchantConfig.setDefaultConfig()` 设置默认配置
2. **多商户模式**：通过 `GlobalMerchantConfig.addConfig()` 添加多个配置，使用时通过 `merchantNo` 指定

### 请求发送方式

1. **JSON API**：直接传入 JSON 对象发送请求
2. **易用 API**：使用类型化的请求对象（如 `TradeOrderRequest`），自动处理序列化和反序列化

### ISV 模式

在 ISV（独立软件提供商）模式下，`MerchantConfig` 需要额外配置：
- `spMerchantNo`：服务商商户号
- `merchantAuthToken`：商户授权令牌

## 环境配置

通过 `Env` 枚举设置环境：
- `Env.UAT`：测试环境
- `Env.PROD`：生产环境

也可通过 `setBaseUrl()` 自定义网关地址。

## 签名机制

- 使用 RSA 加密进行签名和验证
- `RsaUtils` 提供密钥对生成和签名验证功能
- 请求自动签名，响应自动验证

## 依赖说明

- **OkHttp 4.12.0**：HTTP 客户端
- **FastJSON 1.2.83**：JSON 序列化/反序列化
- **commons-lang3 3.18.0**：工具类
- **TestNG 7.5.1**：测试框架

## 开发注意事项

- Java 版本：1.8
- 修改代码后记得运行 `mvn clean compile` 编译并自动修复编译错误
- 新增请求类需继承 `BaseRequest<RESP>` 并实现 `getApiName()` 方法
- 代码符合 SonarQube 规范
