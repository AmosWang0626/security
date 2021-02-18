# security

> 简一 security

默认用户名：`admin` 密码：`000000`，在 `DataInitConfig` 类中初始化的。

## 技术栈

- spring security + oauth2 + jwt
- jpa + h2database【http://localhost:8081/h2】
- knife4j【http://localhost:8081/doc.html】

## Docker

- `cd security-web`
- 构建镜像: `mvn package dockerfile:build`
- 查看镜像: `docker images`
- 运行项目: `docker run -d -p 8888:8081 --name security security`

## 学习概述

#### Spring Security

是什么：身份验证、授权和针对常见攻击的保护。

- **关键词**：**身份认证**、**授权**