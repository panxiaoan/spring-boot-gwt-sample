package com.pxa.sample.server.model.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-07-12 19:00
 */
public class RestResponseVO implements VO {

	private static final long serialVersionUID = -4622915648536624314L;

	private Integer status = 0;
	private List<VO> data;

	public RestResponseVO() {
	}

	public RestResponseVO(Integer status, List<VO> data) {
		super();
		this.status = status;
		this.data = data;
	}

	public RestResponseVO(List<VO> data) {
		super();
		this.data = data;
	}

	public Map<String, RestResponseVO> getResponse() {
		Map<String, RestResponseVO> map = new HashMap<>();
		map.put("response", this);
		return map;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<VO> getData() {
		return data;
	}

	public void setData(List<VO> data) {
		this.data = data;
	}
}
