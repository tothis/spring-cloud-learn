FROM openjdk:8-jre-alpine
# 作者信息
LABEL maintainer="lilei <tothis@qq.com>"
# 接收pom中传递的参数
ARG JAR_FILE
# 复制打包后的jar到docker容器目录下
ADD ${JAR_FILE} /app.jar
# 启动容器时执行
ENTRYPOINT ["java", "-jar", "/app.jar"]
# 指定端口号
EXPOSE 8080