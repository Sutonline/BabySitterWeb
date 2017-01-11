/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午4:36:34
 * cvs: $Id: $
 */
package com.sut.persist.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sut.util.meta.ServiceLevelEnum;
import com.sut.util.meta.ServiceTypeEnum;

/**
 * 服务价格
 * @author Sut
 * @version $Revision:$
 */
public class ServicePrice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private ServiceTypeEnum service;
	private String serviceName;
	private ServiceLevelEnum level;
	private BigDecimal price;
	private String remark;
	
	public ServicePrice() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ServiceTypeEnum getService() {
		return service;
	}

	public void setService(ServiceTypeEnum service) {
		this.service = service;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public ServiceLevelEnum getLevel() {
		return level;
	}

	public void setLevel(ServiceLevelEnum level) {
		this.level = level;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
