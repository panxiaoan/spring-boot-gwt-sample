package com.pxa.sample.client.page;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.pxa.sample.client.SpringBootGWTSample;
import com.pxa.sample.client.rpc.RPCUtil;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-05-03 10:53
 */
public class CenterPage extends VLayout {

	protected SpringBootGWTSample mainPage;

	protected TabSet tabSet;
	protected Tab indexTab;

	protected TextItem usernameItem;
	protected PasswordItem passwordItem;

	public CenterPage(SpringBootGWTSample mainPage) {
		this.mainPage = mainPage;

		this.setWidth100();
		this.setHeight100();
		this.setLayoutMargin(16);

		this.drawUI();
	}

	public void drawUI() {
		this.drawTabSet();
	}

	protected void drawTabSet() {
		tabSet = new TabSet();
		tabSet.setWidth100();
		tabSet.setHeight100();
		tabSet.setDestroyPanes(true);
		tabSet.setPaneContainerOverflow(Overflow.AUTO);
		this.addMember(tabSet);

		this.drawIndexTab();
	}
	
	public void addTab(AbstractPage page) {
		Tab tab = this.tabSet.getTab(page.getPageId());
		if (tab != null) {
			this.tabSet.selectTab(page.getPageId());
			return;
		}

		tab = new Tab();
		tab.setID(page.getPageId());
		tab.setPaneMargin(0);
		tab.setTitle(page.getPageTitle());
		tab.setCanClose(true);
		tab.setPane(page);

		this.tabSet.addTab(tab);
		this.tabSet.selectTab(page.getPageId());
	}

	protected void drawIndexTab() {
		indexTab = new Tab();
		indexTab.setID("defaultTab");

		indexTab.setTitle("Home");
		indexTab.setWidth(70);

		VLayout container = new VLayout();
		container.setWidth100();
		container.setHeight100();
		container.setDefaultLayoutAlign(Alignment.CENTER);

		VLayout topLayout = new VLayout();
		topLayout.setWidth(200);
		topLayout.setHeight(64);
		topLayout.setLayoutAlign(Alignment.CENTER);
		topLayout.setLayoutTopMargin(50);
		topLayout.setMembersMargin(5);

		Label appTitleLbl = new Label("Spring Boot GWT Sample");
		appTitleLbl.setWidth(200);
		appTitleLbl.setHeight(64);
		appTitleLbl.setAlign(Alignment.CENTER);
		topLayout.addMember(appTitleLbl);

		VLayout centerLayout = new VLayout();
		centerLayout.setLayoutAlign(Alignment.CENTER);
		centerLayout.setMembersMargin(10);
		centerLayout.setWidth(200);
		centerLayout.setHeight(300);

		DynamicForm loginForm = new DynamicForm();
		loginForm.setWidth(200);
		loginForm.setPadding(0);
		loginForm.setMargin(0);
		loginForm.setCellPadding(1);
		loginForm.setNumCols(2);
		centerLayout.addMember(loginForm);

		usernameItem = new TextItem();
		usernameItem.setTitle("Username");
		usernameItem.setRequired(true);
		usernameItem.setDefaultValue("admin");

		passwordItem = new PasswordItem();
		passwordItem.setTitle("Password");
		passwordItem.setRequired(true);
		passwordItem.setDefaultValue("123");

		loginForm.setFields(usernameItem, passwordItem);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth(200);
		btnLayout.setMembersMargin(10);
		centerLayout.addMember(btnLayout);

		IButton rpcLoginBtn = new IButton("RPC Login");
		rpcLoginBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				sendRequestByRPC(getFormData());
			}
		});
		btnLayout.addMember(rpcLoginBtn);

		IButton ajaxLoginBtn = new IButton("Ajax Login");
		ajaxLoginBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Map<String, Object> params = getFormData();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("username", new JSONString(params.get("username").toString()));
				jsonObject.put("password", new JSONString(params.get("password").toString()));
				sendRequestByAjax(jsonObject.toString());
			}
		});
		btnLayout.addMember(ajaxLoginBtn);

		container.addMember(topLayout);
		container.addMember(centerLayout);

		indexTab.setPane(container);
		this.tabSet.addTab(indexTab);
	}

	private Map<String, Object> getFormData() {
		String username = usernameItem.getValueAsString();
		String password = passwordItem.getValueAsString();

		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		return params;
	}

	private void sendRequestByRPC(Map<String, Object> params) {
		RPCUtil.createRemoteService().execute(params, new AsyncCallback<Map<String, Object>>() {
			@Override
			public void onFailure(Throwable caught) {
				SC.say(caught.getMessage());
			}

			@Override
			public void onSuccess(Map<String, Object> result) {
				String message = result.get("message").toString();
				SC.say(message);
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
						SC.say("login success: " + response.getText());
					} else {
						SC.say("login error, status code is: " + response.getStatusCode());
					}
				}

				@Override
				public void onError(Request request, Throwable exception) {
					SC.say("login error: " + exception.getMessage());
				}
			});
		} catch (RequestException ex) {
			SC.say(ex.getMessage());
		}
	}
}
