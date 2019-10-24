# from出现在未被注释的第一行
FROM openjdk:8-jre-alpine
# 声明此镜像的作者
MAINTAINER lilei <tothis@qq.com>
# 指定临时文件目录 会在主机/var/lib/docker目录下创建一个临时文件链接到容器的/tmp目录
VOLUME /tmp
# ${JAR_FILE}为pom中属性 复制打包后的jar到docker容器目录下
ADD ${JAR_FILE} /app.jar
# 启动容器时执行
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
# 指定端口号
EXPOSE 8080