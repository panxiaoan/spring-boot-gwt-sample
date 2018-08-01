package com.pxa.sample.client.page.datasource;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.util.JSON;

public final class DSLoader {

	public final static void load(final String dataSourceID, final DSLoadedHandler handler) {

		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, "../" + dataSourceID + "?isc_dataFormat=json");
		try {
			Request request = builder.sendRequest("{}", new RequestCallback() {
				@Override
				public void onResponseReceived(Request arg0, Response response) {

					RestDataSource rds = new RestDataSource(JSON.decode(response.getText()));
					for (OperationBinding binding : rds.getOperationBindings()) {
						binding.setOperationType(DSOperationType.FETCH);
						binding.setDataProtocol(DSProtocol.POSTMESSAGE);
						binding.setDataFormat(DSDataFormat.JSON);
						binding.setDataURL("../" + dataSourceID);
					}
					rds.setID("ea_MyDataSource");
					rds.setDataFormat(DSDataFormat.JSON);
					rds.setDataProtocol(DSProtocol.POSTMESSAGE);
					rds.setDataURL("../" + dataSourceID);
					rds.setUpdateDataURL("../" + dataSourceID);

					handler.onDSLoaded(rds);
				}

				@Override
				public void onError(Request arg0, Throwable arg1) {
					throw new RuntimeException(arg1);
				}
			});
		} catch (RequestException e) {
			e.printStackTrace();
		}
	}
}