/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月5日 上午9:22:14
 * cvs: $Id: $
 */
package com.sut.web.action.staff;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.sut.persist.entity.Staff;
import com.sut.persist.entity.StaffReview;
import com.sut.service.StaffService;
import com.sut.web.action.Execution;

/**
 * 职工Action
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("serial")
public class StaffAction extends Execution { 
	private static final Logger LOG = LoggerFactory.getLogger(StaffAction.class);
	
	//前台传值
	private Staff staff;
	private StaffReview review;

	//注入service
	private StaffService staffService;
	
	//获取requestServlet
	private HttpServletRequest request;
	
	/**
	 * 保存staff
	 * @return
	 */
	public String addStaff() {
		return SUCCESS;
	}
	
	/**
	 * @return
	 */
	public String saveStaff() {
		LOG.info("要保存的staff信息是:{}", this.staff.toString());
		LOG.info("staff的self_content的长度是: {}", this.staff.getSelfIntroduction().length());
		staffService.save(staff);
		return SUCCESS;
	}

	/**
	 * 根据id查看staff信息
	 * @return
	 */
	public String viewStaff() {
		Preconditions.checkArgument(staff != null && staff.getId() > 0, "staff id不能为空!");
		this.staff = staffService.getById(staff.getId());
		LOG.debug("获取到的信息为: {}", staff.toString());
		return SUCCESS;
	}
	
	/**
	 * @return 返回staff list页面
	 */
	public String staffList() {
		return SUCCESS;
	}
	
	public String addReview() {
		this.request = ServletActionContext.getRequest();
		String remoteAddr = this.request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		LOG.info(remoteHost);
		review.setIpAddress(remoteAddr);
		LOG.debug("要保存的信息是:{}", review.toString());
		
		return SUCCESS;
	}
	
	/*************************** Dividing Line ********************************/

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public StaffReview getReview() {
		return review;
	}

	public void setReview(StaffReview review) {
		this.review = review;
	}
	
}
