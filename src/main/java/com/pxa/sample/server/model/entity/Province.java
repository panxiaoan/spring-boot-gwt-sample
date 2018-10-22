package com.pxa.sample.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 省份
 *
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2017-03-01 15:26
 */
@Entity
@Table(name = "SYS_PROVINCE")
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/** 编码 */
	@Column(length = 50, nullable = false)
	protected String code;

	/** 名称 */
	@Column(length = 50, nullable = false)
	protected String name;

	public Province() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
