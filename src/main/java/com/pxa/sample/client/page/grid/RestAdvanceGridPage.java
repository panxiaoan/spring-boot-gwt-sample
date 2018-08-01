package com.pxa.sample.client.page.grid;

import java.util.Date;

import com.pxa.sample.client.page.AbstractPage;
import com.pxa.sample.client.page.datasource.DSLoadedHandler;
import com.pxa.sample.client.page.datasource.DSLoader;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.rpc.RPCManager;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-07-13 15:56
 */
public class RestAdvanceGridPage extends AbstractPage implements DSLoadedHandler {

	private ListGrid ls;

	public RestAdvanceGridPage() {
		super("RestAdvanceGridPage", "Rest Advance Grid");
		this.drawUI();
	}

	public static final native void log(Object... o) /*-{
		console.log(o);
	}-*/;

	protected void drawUI() {
		ToolStrip toolStrip = new ToolStrip();
		toolStrip.setWidth100();
		toolStrip.setOverflow(Overflow.HIDDEN);

		ls = new ListGrid();
		ls.setWidth100();
		ls.setHeight100();
		ls.setAlternateRecordStyles(true);
		ls.setListEndEditAction(RowEndEditAction.NEXT);
		ls.setAutoSaveEdits(false);
		ls.setEditByCell(true);
		ls.setCanSelectCells(true);
		ls.setCanDragSelect(true);
		ls.setSelectOnEdit(true);
		ls.setUseCopyPasteShortcuts(true);
		ls.setAutoFitData(Autofit.HORIZONTAL);
		ls.setShowGridSummary(true);

		IButton loadDefinitionsBtn = new IButton("Load Definitions");
		loadDefinitionsBtn.addClickHandler((e) -> {
			DSLoader.load("/user/list2", RestAdvanceGridPage.this);
		});
		toolStrip.addMember(loadDefinitionsBtn);
		toolStrip.addFill();

		IButton loadDataBtn = new IButton("Load Data");
		loadDataBtn.addClickHandler((e) -> {
			ls.invalidateCache();
			Criteria crit = new Criteria();
			crit.addCriteria("booleanCrit", false);
			crit.addCriteria("dateCrit", new Date());
			crit.addCriteria("StringCriteria", "value");
			ls.fetchData(crit);
		});
		toolStrip.addMember(loadDataBtn);

		IButton saveChangesBtn = new IButton("Save Changes");
		saveChangesBtn.addClickHandler((e) -> ls.saveAllEdits());
		toolStrip.addMember(saveChangesBtn);

		IButton addNewBtn = new IButton("Add New");
		addNewBtn.addClickHandler((e) -> ls.startEditingNew());
		toolStrip.addMember(addNewBtn);

		IButton deleteSelectedBtn = new IButton("Delete Selected");
		deleteSelectedBtn.addClickHandler((e) -> {
			ListGridRecord[] selectedRecords = ls.getSelectedRecords();
			boolean wasQueuing = RPCManager.startQueue();
			for (ListGridRecord rec : selectedRecords) {
				ls.removeData(rec);
			}
			if (!wasQueuing) {
				RPCManager.sendQueue();
			}
		});
		toolStrip.addMember(deleteSelectedBtn);

		IButton customOpButton = new IButton("Custom Operation");
		customOpButton.addClickHandler((e) -> {
			Record data = new Record();
			data.setAttribute("attribute", "value");
			DSCallback callback = new DSCallback() {

				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					log("CustomOP Callback");
					log(dsResponse);
					log(data);
					log(dsRequest);
				}
			};
			DSRequest requestProperties = new DSRequest();
			requestProperties.setAttribute("requestPropertiesAttr", "value");
			ls.getDataSource().performCustomOperation("customOperation", data, callback, requestProperties);
		});
		toolStrip.addMember(customOpButton);
		
		this.addMember(toolStrip);
		this.addMember(ls);
	}

	@Override
	public void onDSLoaded(RestDataSource dataSource) {
		ls.setDataSource(dataSource);
	}

}
