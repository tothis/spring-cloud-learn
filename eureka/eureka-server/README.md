eureka-server
***
运行
```shell
docker run --name eureka-test -p 8001:8001 -d eureka-server:1.0
```
删除
```shell
docker stop eureka-test && docker rm eureka-test && docker rmi eureka-server:1.0
```
