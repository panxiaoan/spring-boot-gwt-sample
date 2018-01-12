# Spring Boot GWT Sample

<img src="https://github.com/panxiaoan/spring-boot-gwt-sample/blob/master/docs/media/gwt-rpc.png" width="780" height="500" alt="GWT RPC 与 SpringBoot 交互原理图"/>

## 环境
- jdk 1.8
- maven 3.3.9
- spring-boot 1.5.9
- gwt 2.8.1

## 将 Java 编译为 JavaScript，默认已编译
```shell
cd setup
./gwt-compile.sh
```

## 运行
```
RunSpringBootGWTSampleApplication
```

## 访问
- http://localhost:8080
- 账号：admin
- 密码：123

## GWT RPC
```java
    private void sendRequestByRPC(Map<String, Object> params) {
        RPCUtil.createRemoteService().execute(params, new AsyncCallback<Map<String, Object>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(Map<String, Object> result) {
                String message = result.get("message").toString();
                Window.alert(message);
            }
        });
    }
```

## GWT Ajax
- 需要引入 GWT HTTP 模块：<inherits name="com.google.gwt.http.HTTP" />
```java
    /**
    * http://localhost:8080/login 
    */
    private void sendRequestByAjax(String json) {
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, GWT.getHostPageBaseURL() + "login");
        requestBuilder.setHeader("Content-Type", "application/json");
        try {
            requestBuilder.sendRequest(json, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (response.getStatusCode() == 200) {
                        Window.alert("login success: " + response.getText());
                    } else {
                        Window.alert("login error, status code is: " + response.getStatusCode());
                    }
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    Window.alert("login error: " + exception.getMessage());
                }
            });
        } catch (RequestException ex) {
            Window.alert(ex.getMessage());
        }
    }
```
