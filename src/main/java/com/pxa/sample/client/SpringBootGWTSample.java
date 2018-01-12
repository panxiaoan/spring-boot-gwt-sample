package com.pxa.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.pxa.sample.client.rpc.RPCUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: 2018-01-11 19:47
 */
public class SpringBootGWTSample implements EntryPoint {

    private final TextBox usernameUI = new TextBox();
    private final PasswordTextBox passwordUI = new PasswordTextBox();

    @Override
    public void onModuleLoad() {

        VerticalPanel container = new VerticalPanel();
        container.setSpacing(10);

        container.add(new Label("用户登录"));

        usernameUI.setFocus(true);
        container.add(new Label("账号："));
        container.add(usernameUI);

        container.add(new Label("密码："));
        container.add(passwordUI);

        Button rpcBtn = new Button("<b>Login By RPC</b>", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sendRequestByRPC(getFormData());
            }
        });
        rpcBtn.setWidth("100px");
        rpcBtn.setHeight("25px");
        container.add(rpcBtn);

        Button ajaxBtn = new Button("<b>Login By Ajax</b>", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Map<String, Object> params = getFormData();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("username", new JSONString(params.get("username").toString()));
                jsonObject.put("password", new JSONString(params.get("password").toString()));
                sendRequestByAjax(jsonObject.toString());
            }
        });
        ajaxBtn.setWidth("100px");
        ajaxBtn.setHeight("25px");
        container.add(ajaxBtn);

        RootLayoutPanel.get().add(container);
    }

    private Map<String, Object> getFormData() {
        String username = usernameUI.getValue();
        String password = passwordUI.getValue();

        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        return params;
    }

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
}
