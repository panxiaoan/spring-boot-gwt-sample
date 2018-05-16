package com.pxa.sample.client.page.grid;

import com.pxa.sample.client.page.AbstractPage;
import com.pxa.sample.client.page.datasource.WorldDS;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-05-03 13:53
 */
public class GridFilterPage extends AbstractPage {

	public GridFilterPage() {
		super("GridFilterPage", "Grid Filter Sample");
		
		this.drawUI();
	}

	public void drawUI() {
		
		final ListGrid listGrid = new ListGrid();
		listGrid.setWidth100();
		listGrid.setHeight100();
		listGrid.setAlternateRecordStyles(true);
		listGrid.setShowFilterEditor(true);
		listGrid.setDataSource(WorldDS.getInstance());
		listGrid.setAutoFetchData(true);
		
		ListGridField countryCodeField = new ListGridField("countryCode", "Code", 50);
		
		ListGridField nameField = new ListGridField("countryName", "Country");
		
		ListGridField capitalField = new ListGridField("capital", "Capital");
		
		ListGridField continentField = new ListGridField("continent", "Continent");
		
		ListGridField areaField = new ListGridField("area", "Area (km²)");
		
		ListGridField populationField = new ListGridField("population", "Population");

		AdvancedCriteria criteria = new AdvancedCriteria(OperatorId.AND,
				new AdvancedCriteria[] { new AdvancedCriteria("countryName", OperatorId.INOT_CONTAINS, "i"),
						new AdvancedCriteria("capital", OperatorId.INOT_STARTS_WITH, "p") });
		listGrid.setAllowFilterOperators(true);
		listGrid.setCriteria(criteria);
		
		listGrid.setFields(countryCodeField, nameField, capitalField, continentField, areaField, populationField);
		
		this.addMember(listGrid);
	}

}
