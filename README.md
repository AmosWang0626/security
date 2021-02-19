# security

> 简一 security

默认用户名：`admin` 密码：`000000`，在 `DataInitConfig` 类中初始化的。

技术整合能力。一上来就整合，容易混淆，可以先分散学习，了解都有哪些功能，最后整合，消化吸收。

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

#### 1. Spring Security

> Spring Security是一套安全框架，基于角色的权限控制对用户的访问权限进行控制，核心思想是通过一系列的 Filter Chain 来进行拦截过滤。

- 核心功能是：**认证 Authentication**、**授权 Authorization** 和 **针对常见攻击的保护**
- 过滤器入口：`DelegatingFilterProxy`

---

##### 权限、角色相关

- hasAuthority 访问权限，需要包含所有
- hasAnyAuthority 访问权限，包含一个即可
- hasRole 访问角色，需要包含所有
- hasAnyRole 访问角色，包含一个即可


- @Secured({"ROLE_dev", "ROLE_ops"}) 角色，getAuthorities里返回的角色必须有 ROLE_ 前缀
- @PreAuthorize("hasAnyAuthority('admin')") 方法执行前校验
- @PostAuthorize("hasAnyAuthority('manager')") 方法执行后校验


- @PreFilter("filterObject.username == 'admin'") 传入参数过滤
- @PostFilter("filterObject.age != null and filterObject.age % 2 == 0") 返回结果过滤

#### 2. OAuth2

> OAuth2 是一种授权机制，主要用来颁发令牌（token）

最常见的例子就是通过QQ、微信登录第三方网站。

- 单体架构，一般用不到 Oauth2，Spring Security已足够
- 微服务架构，Oauth2可用作用户账号密码登录鉴权，微服务间通过公钥私钥访问鉴权