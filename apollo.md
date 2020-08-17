# apollo
***
服务端部署参考 https://github.com/ctripcorp/apollo/wiki/分布式部署指南
***
[ApolloConfigDB](https://github.com/ctripcorp/apollo/blob/master/scripts/sql/apolloconfigdb.sql)
[ApolloPortalDB](https://github.com/ctripcorp/apollo/blob/master/scripts/sql/apolloportaldb.sql)
***
部署Apollo Config Service
```shell
docker run -d \
--name apollo-configservice \
-p 8080:8080 \
-e SPRING_DATASOURCE_URL="jdbc:mysql://192.168.92.134:3306/ApolloConfigDB?characterEncoding=utf8" \
-e SPRING_DATASOURCE_USERNAME=root \
-e SPRING_DATASOURCE_PASSWORD=123456 \
-v /usr/local/software/docker/apollo/configservice/logs:/opt/logs \
apolloconfig/apollo-configservice
```
部署Apollo Admin Service
```shell
docker run -d \
--name apollo-adminservice \
-p 8090:8090 \
-e SPRING_DATASOURCE_URL="jdbc:mysql://192.168.92.134:3306/ApolloConfigDB?characterEncoding=utf8" \
-e SPRING_DATASOURCE_USERNAME=root \
-e SPRING_DATASOURCE_PASSWORD=123456 \
-v /usr/local/software/docker/apollo/adminservice/logs:/opt/logs \
apolloconfig/apollo-adminservice
```
部署Apollo Portal
```shell
docker run -d \
--name apollo-portal \
-p 8070:8070 \
-e SPRING_DATASOURCE_URL="jdbc:mysql://192.168.92.134:3306/ApolloPortalDB?characterEncoding=utf8" \
-e SPRING_DATASOURCE_USERNAME=root \
-e SPRING_DATASOURCE_PASSWORD=123456 \
-e APOLLO_PORTAL_ENVS=dev,pro \
-e DEV_META=http://192.168.92.134:8080 \
-e PRO_META=http://192.168.92.134:8080 \
-v /usr/local/software/docker/apollo/portal/logs:/opt/logs \
apolloconfig/apollo-portal

# 浏览器访问 http://192.168.92.134:8070 默认账户 apollo 默认密码 admin
```
***
客户端接入参考 https://github.com/ctripcorp/apollo/wiki/Java客户端使用指南