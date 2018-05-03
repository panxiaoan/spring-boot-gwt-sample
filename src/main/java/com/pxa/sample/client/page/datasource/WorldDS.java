package com.pxa.sample.client.page.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-05-03 14:01
 */
public class WorldDS extends DataSource {
	private static WorldDS instance = null;

	public static WorldDS getInstance() {
		if (instance == null) {
			instance = new WorldDS("GridFilterSampleDS");
		}
		return instance;
	}

	public WorldDS(String id) {

		setID(id);
		setRecordXPath("/List/country");
		DataSourceIntegerField pkField = new DataSourceIntegerField("pk");
		pkField.setHidden(true);
		pkField.setPrimaryKey(true);

		DataSourceTextField countryCodeField = new DataSourceTextField("countryCode", "Code");
		countryCodeField.setRequired(true);

		DataSourceTextField countryNameField = new DataSourceTextField("countryName", "Country");
		countryNameField.setRequired(true);

		DataSourceTextField capitalField = new DataSourceTextField("capital", "Capital");
		DataSourceTextField governmentField = new DataSourceTextField("government", "Government", 500);

		DataSourceBooleanField memberG8Field = new DataSourceBooleanField("member_g8", "G8");

		DataSourceTextField continentField = new DataSourceTextField("continent", "Continent");
		continentField.setValueMap("Europe", "Asia", "North America", "Australia/Oceania", "South America", "Africa");

		DataSourceDateField independenceField = new DataSourceDateField("independence", "Nationhood");
		DataSourceFloatField areaField = new DataSourceFloatField("area", "Area (km²)");
		DataSourceIntegerField populationField = new DataSourceIntegerField("population", "Population");
		DataSourceFloatField gdpField = new DataSourceFloatField("gdp", "GDP ($M)");

		setFields(pkField, countryCodeField, countryNameField, capitalField, governmentField, memberG8Field,
				continentField, independenceField, areaField, populationField, gdpField);

		setDataURL("ds/world.xml");
		setClientOnly(true);
	}
}
