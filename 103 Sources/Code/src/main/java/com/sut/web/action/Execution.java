/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月22日 下午4:56:06
 * cvs: $Id: $
 */
package com.sut.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action基类，方便统一增加
 * @author Sut
 * @version $Revision:$
 */
public class Execution extends ActionSupport implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Convenience method to get the request
	 * @return current request
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	/**
	 * Convience method to get the response
	 * @return current response
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	/**
	 * Convience method to get the session
	 * @return current session
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	
	/**
	 * @param errorCode
	 * @param params
	 */
	public void addActionError(String errorCode, String[] params) {
	}
	
	
}
