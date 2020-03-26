# security
> 简一 security

## 技术栈
- 数据库：jpa
- 前端：Vue

## 增加 Docker 配置
- 构建镜像: mvn package dockerfile:build
- 查看镜像: docker images
- 运行项目: docker run -d -p 8888:8081 --name permit amos/permit
