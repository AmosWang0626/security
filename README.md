# security

> 简一 security

## 技术栈

- jpa
- h2database【http://localhost:8081/h2】
- knife4j【http://localhost:8081/doc.html】

## 增加 Docker 配置

- 构建镜像: `mvn package dockerfile:build`
- 查看镜像: `docker images`
- 运行项目: `docker run -d -p 8888:8081 --name security security`
