package com.pxa.sample.client;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-08-07 15:05
 */
public class RestResult implements IsSerializable {
	private Integer status;
	private String message;

	public RestResult() {
	}

	public RestResult(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
