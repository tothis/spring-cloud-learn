查看客户端配置
```
http://localhost:8082/config-client/dev
http://localhost:8082/config-client-dev.json
http://localhost:8082/config-client-dev.yaml
http://localhost:8082/config-client-dev.yml
http://localhost:8082/config-client-dev.properties
```
刷新配置
```shell
curl -X POST http://localhost:8082/actuator/bus-refresh
```