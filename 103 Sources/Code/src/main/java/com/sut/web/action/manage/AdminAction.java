/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年11月1日 下午8:59:59
 * cvs: $Id: $
 */
package com.sut.web.action.manage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.sut.service.LoginService;

/**
 * 后台管理登陆Action
 * @author sut
 * @version $Revision:$
 */
@SuppressWarnings("serial")
public class AdminAction extends ActionSupport {
	
	private static final Logger log = LoggerFactory.getLogger(AdminAction.class);
	
	
	//前台变量
	private String username;
	private String password;
	private String verifycode;
	
	//注入service
	private LoginService loginService;
	
	/**
	 * 返回登陆后的页面
	 * @return
	 */
	public String login() {
		log.info("shrubs的信息是:===");
		return SUCCESS;
	}
	
	public String loginSubmit() {
		log.info("进行login验证");
		boolean b = loginService.login(username, password);
		if (b)
			return SUCCESS;
		else
			return INPUT;
	}
	
	/**
	 * @return 返回后台管理的登陆页面
	 */
	public String index() {
		log.info("进入index页面");
		return SUCCESS;
	}
	
	public String indexBody() {
		return SUCCESS;
	}
	
	/**
	 * @return 返回admin的index页面
	 */
	public String admin() {
		return SUCCESS;
	}
	
	/**
	 * @return 返回的是验证码页面
	 */
	public String authCode() {
		return SUCCESS;
	}

	
	/******************************************* Dividing Line *******************************/
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
}
