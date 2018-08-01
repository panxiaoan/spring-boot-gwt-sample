package com.pxa.sample.client.page.grid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.pxa.sample.client.page.AbstractPage;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.util.JSON;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

/**
 * Rest Grid Page
 * 
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-07-12 16:44
 */
public class RestGridPage extends AbstractPage {

	private ListGrid listGrid;

	public RestGridPage() {
		super("RestGridPage", "Rest Grid Sample");

		this.drawUI();
	}

	public void drawUI() {
		
		ToolStrip toolStrip = new ToolStrip();
		toolStrip.setWidth100();
		toolStrip.setOverflow(Overflow.HIDDEN); 
		
		ToolStripButton loadBtn = new ToolStripButton("Load");
		loadBtn.addClickHandler((e) -> {
			this.loadData();
		});
		toolStrip.addMember(loadBtn);

		listGrid = new ListGrid();
		listGrid.setWidth100();
		listGrid.setHeight100();
		listGrid.setAlternateRecordStyles(true);
		listGrid.setListEndEditAction(RowEndEditAction.NEXT);
		listGrid.setAutoSaveEdits(false);
		listGrid.setEditByCell(true);
		listGrid.setCanSelectCells(true);
		listGrid.setCanDragSelect(true);
		listGrid.setSelectOnEdit(true);
		listGrid.setUseCopyPasteShortcuts(true);
		listGrid.setAutoFitData(Autofit.HORIZONTAL);
		
		ListGridField idField = new ListGridField("id", "序号", 50);
		ListGridField usernameField = new ListGridField("username", " 账号");
		ListGridField nameField = new ListGridField("name", "姓名");
		ListGridField ageField = new ListGridField("age", "年龄");
		ListGridField sexField = new ListGridField("sex", "性别");
		ListGridField passwordField = new ListGridField("password", "密码");

		listGrid.setFields(idField, usernameField, nameField, ageField, sexField, passwordField);

		this.addMember(toolStrip);
		this.addMember(listGrid);

	}

	public void loadData() {
		String restUrl = GWT.getHostPageBaseURL() + "/user/list";
		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, restUrl);
		requestBuilder.setHeader("Content-Type", "application/json");

		try {
			requestBuilder.sendRequest("{}", new RequestCallback() {
				@Override
				public void onResponseReceived(Request request, Response response) {
					if (response.getStatusCode() != 200) {
						SC.say("send request error, status code is: " + response.getStatusCode());
					}

					SC.say(response.getText());

					RestDataSource restDataSource = new RestDataSource(JSON.decode(response.getText()));
					for (OperationBinding binding : restDataSource.getOperationBindings()) {
						binding.setOperationType(DSOperationType.FETCH);
						binding.setDataProtocol(DSProtocol.POSTMESSAGE);
						binding.setDataFormat(DSDataFormat.JSON);
						binding.setDataURL(restUrl);
					}
					restDataSource.setID("UserListDS");
					restDataSource.setDataFormat(DSDataFormat.JSON);
					restDataSource.setDataProtocol(DSProtocol.POSTMESSAGE);
					restDataSource.setDataURL(restUrl);
					restDataSource.setUpdateDataURL(restUrl);

//					DataSourceField idField = new DataSourceField("id", FieldType.INTEGER, "序号", 50);
//					DataSourceField usernameField = new DataSourceField("username", FieldType.TEXT, " 账号");
//					DataSourceField nameField = new DataSourceField("name", FieldType.TEXT, "姓名");
//					DataSourceField ageField = new DataSourceField("age", FieldType.TEXT, "年龄");
//					DataSourceField sexField = new DataSourceField("sex", FieldType.TEXT, "性别");
//					DataSourceField passwordField = new DataSourceField("password", FieldType.TEXT, "密码");
//
//					restDataSource.setFields(idField, usernameField, nameField, ageField, sexField, passwordField);

					listGrid.setDataSource(restDataSource);
				}

				@Override
				public void onError(Request request, Throwable exception) {
					SC.say("error: " + exception.getMessage());
				}
			});
		} catch (RequestException ex) {
			SC.say(ex.getMessage());
		}
	}

}
