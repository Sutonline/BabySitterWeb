/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午3:57:30
 * cvs: $Id: $
 */
package com.sut.persist.entity;

import com.google.common.base.MoreObjects;
import com.sut.util.meta.EducationLevelEnum;
import com.sut.util.meta.HealthyStatusEnum;
import com.sut.util.meta.ServiceTypeEnum;
import com.sut.util.meta.StaffLevelEnum;

/**
 * 职工信息
 * @author Sut
 * @version $Revision:$
 */
public class Staff implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String staffName;
	private String imgPath;
	private StaffLevelEnum staffLevel;
	private java.util.Date birthDate;
	private java.lang.String address;
	private HealthyStatusEnum healthyStatus;
	private EducationLevelEnum educationLevel;
	private int workYears;
	private String selfIntroduction;
	private String cert;
	private String remark;
	private ServiceTypeEnum serviceType;
	private String mobile;
	private String qqNumber;
	private String webchatNumber;
	private String webchatQrcode;
	
	/**
	 * default Constructor
	 */
	public Staff() {
		super();
	}

    
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public StaffLevelEnum getStaffLevel() {
		return staffLevel;
	}


	public void setStaffLevel(StaffLevelEnum staffLevel) {
		this.staffLevel = staffLevel;
	}


	public java.util.Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.util.Date birthDate) {
		this.birthDate = birthDate;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public HealthyStatusEnum getHealthyStatus() {
		return healthyStatus;
	}

	public void setHealthyStatus(HealthyStatusEnum healthyStatus) {
		this.healthyStatus = healthyStatus;
	}

	public EducationLevelEnum getEducationLevel() {
		return educationLevel;
	}


	public void setEducationLevel(EducationLevelEnum educationLevel) {
		this.educationLevel = educationLevel;
	}

	public int getWorkYears() {
		return workYears;
	}

	public void setWorkYears(int workYears) {
		this.workYears = workYears;
	}

    
	public String getSelfIntroduction() {
		return selfIntroduction;
	}


	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ServiceTypeEnum getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceTypeEnum serviceType) {
		this.serviceType = serviceType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	public String getWebchatNumber() {
		return webchatNumber;
	}

	public void setWebchatNumber(String webchatNumber) {
		this.webchatNumber = webchatNumber;
	}

	public String getWebchatQrcode() {
		return webchatQrcode;
	}

	public void setWebchatQrcode(String webchatQrcode) {
		this.webchatQrcode = webchatQrcode;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Staff.class)
				.add("id", id)
				.add("staffName", staffName)
				.add("imgPath", imgPath)
				.add("level", staffLevel)
				.add("birthDate", birthDate)
				.add("address", address)
				.add("healthyStatus", healthyStatus)
				.add("education", educationLevel)
				.add("workYears", workYears)
				.add("selfIntroduction", selfIntroduction)
				.add("cert", cert)
				.add("remark", remark)
				.add("serviceType", serviceType)
				.add("mobile", mobile)
				.add("qqNumber", qqNumber)
				.add("webChatNumber", webchatNumber)
				.add("webChatQrcode", webchatQrcode)
				.toString();
	}
	
}
