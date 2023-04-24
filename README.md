# Spring Boot GWT Sample

<img src="https://github.com/panxiaoan/spring-boot-gwt-sample/blob/master/docs/media/gwt-rpc.png" width="600" height="350" alt="GWT RPC 与 SpringBoot 交互原理图"/>

<img src="https://github.com/panxiaoan/spring-boot-gwt-sample/blob/master/docs/media/sample.png" width="600" height="350" alt="主页"/>

## 环境

- jdk 11
- maven 3.3.9
- 下载 SmartGWT JAR：mvn com.isomorphic:isc-maven-plugin:install -Dproduct=SMARTGWT -Dlicense=LGPL -DbuildNumber=13.0p

## 依赖框架

- spring-boot 2.0.3
- gwt 2.10.0
- smartgwt 13.0

## 演示场景

- spring-boot 常用功能
- gwt 常用功能
- 与 jenkins 整合
- 与 jenkins & docker 整合
- 与 jenkins & docker & kubernetes 整合

## 将 Java 编译为 JavaScript，默认已编译

```shell
cd setup
./mvn-gwt-compile.sh
```

## 运行

```
RunSpringBootGWTSampleApplication
```

## 访问

- http://localhost:8080
- 账号：admin
- 密码：123

## 其他

- How TO relogin with SpringSecurity 3.0
  https://forums.smartclient.com/forum/smart-gwt-technical-q-a/9888-how-to-relogin-with-springsecurity-3-0?t=9633
