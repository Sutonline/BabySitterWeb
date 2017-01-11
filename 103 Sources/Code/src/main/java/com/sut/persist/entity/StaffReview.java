/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午4:32:15
 * cvs: $Id: $
 */
package com.sut.persist.entity;

import java.io.Serializable;

import com.google.common.base.MoreObjects;
import com.sut.util.meta.ArticleStatusEnum;
import com.sut.util.meta.ContactTypeEnum;

/**
 * 职工评价
 * @author Sut
 * @version $Revision:$
 */
public class StaffReview implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public StaffReview() {
		super();
	}
	
	private long id;
	private long staffId;
	private String nickName;
	private java.util.Date reviewDate;
	private String remark;
	private ContactTypeEnum contactType;
	private String contactNumber;
	private String comment;
	private ArticleStatusEnum reviewStatus;
	private String ipAddress;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public java.util.Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(java.util.Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ContactTypeEnum getContactType() {
		return contactType;
	}
	public void setContactType(ContactTypeEnum contactType) {
		this.contactType = contactType;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public ArticleStatusEnum getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(ArticleStatusEnum reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(StaffReview.class)
				.add("id", id)
				.add("staffId", staffId)
				.add("nickName", nickName)
				.add("reviewDate", reviewDate)
				.add("remark", remark)
				.add("contactType", contactType)
				.add("contactNumber", contactNumber)
				.add("contactNumber", contactNumber)
				.add("comment", comment)
				.add("ipAddress", ipAddress)
				.toString();
	}

}
