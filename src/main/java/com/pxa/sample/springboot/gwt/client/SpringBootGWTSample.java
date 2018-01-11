package com.pxa.sample.springboot.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.server.MessageFormatUtils;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.pxa.sample.springboot.gwt.client.rpc.RPCUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 */
public class SpringBootGWTSample implements EntryPoint {
    @Override
    public void onModuleLoad() {

        VerticalPanel container = new VerticalPanel();
        container.setSpacing(10);

        container.add(new Label("用户登录"));

        final TextBox usernameUI = new TextBox();
        usernameUI.setFocus(true);
        container.add(new Label("账号："));
        container.add(usernameUI);

        final PasswordTextBox passwordUI = new PasswordTextBox();
        container.add(new Label("密码："));
        container.add(passwordUI);

        Button btn = new Button("<b>登录</b>", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String username = usernameUI.getValue();
                String password = passwordUI.getValue();

                Map<String, Object> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);

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
        });
        btn.setWidth("100px");
        btn.setHeight("25px");
        container.add(btn);

        RootLayoutPanel.get().add(container);
    }
}
