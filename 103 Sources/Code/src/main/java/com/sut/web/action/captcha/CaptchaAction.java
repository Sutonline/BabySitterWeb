/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年11月27日 上午9:24:36
 * cvs: $Id: $
 */
package com.sut.web.action.captcha;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Captcha Action
 * @author sut
 * @version $Revision:$
 */
public class CaptchaAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {
	

	/**
	 * default SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private static final int width = 130;
	private static final int height = 32;
	
	private HttpServletResponse httpservletresponse;
	private HttpServletRequest httpservletrequest;
	private Map<String, Object> session;
	private String captchaAnswer;
	private boolean verifyResult;
	
	//返回前台的json数据
	private JSONObject jsonObject;
	
	/**
	 * @return 返回验证码
	 */
	public void captcha() {
		Captcha captcha = (new nl.captcha.Captcha.Builder(width, height)).addText().addBackground(new GradiatedBackgroundProducer()).gimp().addNoise().addBorder().build();
        CaptchaServletUtil.writeImage(httpservletresponse, captcha.getImage());
        httpservletrequest.getSession().setAttribute("simpleCaptcha", captcha);
	}
	
	public String verify() {
		Captcha captcha = (Captcha) session.get(Captcha.NAME);
		if (captcha.isCorrect(captchaAnswer)) 
			verifyResult = true;
		else 
			verifyResult = false;
		jsonObject = new JSONObject();
		jsonObject.put("verifyResult", verifyResult);
		System.out.println(jsonObject.toString());
		return SUCCESS;
	}

	/**
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.httpservletresponse = response;
	}

	/**
	 * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.httpservletrequest = request;
	}

	/**
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getCaptchaAnswer() {
		return captchaAnswer;
	}

	public void setCaptchaAnswer(String captchaAnswer) {
		this.captchaAnswer = captchaAnswer;
	}

	public boolean isVerifyResult() {
		return verifyResult;
	}

	public void setVerifyResult(boolean verifyResult) {
		this.verifyResult = verifyResult;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	
	
}
