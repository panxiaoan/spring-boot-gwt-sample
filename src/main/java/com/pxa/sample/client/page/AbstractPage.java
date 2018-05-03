package com.pxa.sample.client.page;

import com.smartgwt.client.widgets.layout.VLayout;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-05-03 13:47
 */
public class AbstractPage extends VLayout {
	private String pageId;
	private String pageTitle;

	public AbstractPage(String pageId, String pageTitle) {
		this.pageId = pageId;
		this.pageTitle = pageTitle;
		
		this.setWidth100();  
		this.setHeight100();
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
}
