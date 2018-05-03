package com.pxa.sample.client.page;

import com.google.gwt.user.client.Window;
import com.pxa.sample.client.SpringBootGWTSample;
import com.pxa.sample.client.page.grid.GridFilterPage;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.toolbar.ToolStripMenuButton;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-05-03 10:44
 */
public class TopPage extends VLayout {

	protected SpringBootGWTSample mainPage;
	protected ToolStrip menuBar;

	public TopPage(SpringBootGWTSample mainPage) {
		this.mainPage = mainPage;

		this.setWidth100();
		this.setHeight(32);
		this.setBorder("0px solid blue");

		this.drawUI();
	}

	public void drawUI() {
		this.drawMenuBar();
		this.drawGridMenu();
	}

	private void drawMenuBar() {
		menuBar = new ToolStrip();
		menuBar.setWidth100();
		menuBar.setHeight(32);
		menuBar.addSpacer(3);
		this.addMember(menuBar);

		ToolStripButton logoBtn = new ToolStripButton("<b>Spring Boot GWT Sample</b>");
		logoBtn.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.open("https://github.com/panxiaoan/spring-boot-gwt-sample", "_blank", null);
			}
		});
		menuBar.addButton(logoBtn);
	}

	private void drawGridMenu() {
		Menu menu = new Menu();
		menu.setAutoDraw(Boolean.FALSE);
		ToolStripMenuButton menuBtn = new ToolStripMenuButton("Grid", menu);
		menuBar.addMenuButton(menuBtn);

		MenuItem menuItem1 = new MenuItem("Grid Filter Sample");
		menuItem1.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			@Override
			public void onClick(MenuItemClickEvent event) {
				GridFilterPage page = new GridFilterPage();
				SpringBootGWTSample.centerPage.addTab(page);
			}
		});
		menu.addItem(menuItem1);
		
	}
}
