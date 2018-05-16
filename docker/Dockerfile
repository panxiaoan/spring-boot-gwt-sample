# 基础镜像
FROM index.tenxcloud.com/tenxcloud/java:8

# 作者
MAINTAINER panxiaoan(xiaoan.pan@qq.com)

# 将 Spring Boot 应用复制到镜像中
ADD spring-boot-gwt-sample-0.0.1.jar /opt

# 切换目录，相当于 cd 命令
WORKDIR /opt

# 在容器中运行的命令
CMD ["java","-jar","spring-boot-gwt-sample-0.0.1.jar"]