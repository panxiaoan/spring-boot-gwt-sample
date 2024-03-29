package com.pxa.sample.client.page;

import com.google.gwt.user.client.Window;
import com.pxa.sample.client.SpringBootGWTSample;
import com.pxa.sample.client.kit.UIKit;
import com.pxa.sample.client.page.grid.GridFilterPage;
import com.pxa.sample.client.page.grid.RestAdvanceGridPage;
import com.pxa.sample.client.page.grid.RestGridPage;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.toolbar.ToolStripMenuButton;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-05-03 10:44
 */
public class TopPage extends VLayout {

    protected SpringBootGWTSample mainPage;
    protected ToolStrip menuBar;
    protected Boolean fullScreen = Boolean.FALSE;

    public static native void fullScreen() /*-{ $wnd.launchFullScreen(); }-*/;

    public static native void exitFullScreen() /*-{ $wnd.exitFullScreen(); }-*/;

    private static final Map<String, String> SKIN_MAP = new LinkedHashMap<>() {{
        put("Tahoe", "fontIncrease=0&sizeIncrease=0");
        put("Twilight", "fontIncrease=0&sizeIncrease=0");
        put("Stratus", "fontIncrease=0&sizeIncrease=0");
        put("Obsidian", "fontIncrease=0&sizeIncrease=0");
        put("default", "fontIncrease=0&sizeIncrease=0");
    }};

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

        this.menuBar.addFill();

        ToolStripButton logoutBtn = new ToolStripButton(UIKit.createTopBarTitle("Logout", "fa-sign-out-alt", "blue"));
        menuBar.addButton(logoutBtn);

        ToolStripButton fullScreenBtn = new ToolStripButton(UIKit.createTopBarTitle("", "fa-arrows-alt", "blue"));
        fullScreenBtn.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (fullScreen) {
                    fullScreen = Boolean.FALSE;
                    exitFullScreen();
                } else {
                    fullScreen = Boolean.TRUE;
                    fullScreen();
                }
            }
        });

        menuBar.addButton(fullScreenBtn);
    }

    public String formatString(String str, String... args) {
        for (int i = 0; i < args.length; i++) {
            str = str.replace("{" + i + "}", args[i]);
        }
        return str;
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

        ToolStripMenuButton gridMenuBtn = new ToolStripMenuButton("Grid", menu);
        menuBar.addMenuButton(gridMenuBtn);

        MenuItem gridMenuItem = new MenuItem("Grid Filter Sample");
        gridMenuItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            @Override
            public void onClick(MenuItemClickEvent event) {
                GridFilterPage page = new GridFilterPage();
                SpringBootGWTSample.centerPage.addTab(page);
            }
        });
        menu.addItem(gridMenuItem);

        MenuItem restGridMenuItem = new MenuItem("Rest Grid Sample");
        restGridMenuItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            @Override
            public void onClick(MenuItemClickEvent event) {
                RestGridPage page = new RestGridPage();
                SpringBootGWTSample.centerPage.addTab(page);
            }
        });
        menu.addItem(restGridMenuItem);

        MenuItem restAdvanceGridMenuItem = new MenuItem("Rest Advance Grid Sample");
        restAdvanceGridMenuItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            @Override
            public void onClick(MenuItemClickEvent event) {
                RestAdvanceGridPage page = new RestAdvanceGridPage();
                SpringBootGWTSample.centerPage.addTab(page);
            }
        });
        menu.addItem(restAdvanceGridMenuItem);

    }
}
