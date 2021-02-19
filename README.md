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

> **身份验证**、**授权**和**针对常见攻击的保护**。

- 本质上就是一系列过滤器
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