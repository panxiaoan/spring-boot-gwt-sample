package com.pxa.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.pxa.sample.client.page.CenterPage;
import com.pxa.sample.client.page.TopPage;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-01-11 19:47
 */
public class SpringBootGWTSample implements EntryPoint {

    public VLayout mainLayout;
    public static TopPage topPage;
    public static CenterPage centerPage;

    @Override
    public void onModuleLoad() {
        mainLayout = new VLayout() {
            {
                setWidth100();
                setHeight100();
            }

            @Override
            protected void onInit() {
                super.onInit();
            }
        };
        topPage = new TopPage(this);
        mainLayout.addMember(topPage);

        centerPage = new CenterPage(this);
        mainLayout.addMember(centerPage);

        RootLayoutPanel.get().add(mainLayout);
    }

}
