package com.pxa.sample.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 城市
 *
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2017-03-01 15:26
 */
@Entity
@Table(name = "SYS_CITY")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/** 省份 */
	protected Long provinceId;

	@Column(length = 50, nullable = false)
	protected String code;

	@Column(length = 50, nullable = false)
	protected String name;

	public City() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
