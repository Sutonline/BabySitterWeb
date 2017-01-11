/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月21日 下午5:00:30
 * cvs: $Id: $
 */
package com.sut.web.action;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;
import com.sut.util.StringUtil;

/**
 * 自定义的JSONObject
 * @author Sut
 * @version $Revision:$
 */
public class JSONResult implements Result, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//参数
	private String jsonObject;
	private String contentType;
	private String charset;
	
	private static final boolean isByte = false;
	
	/**
	 * default Parameter
	 */
	private static final String defaultParam = "jsonObject";
	
	/**
	 * @see com.opensymphony.xwork2.Result#execute(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		ValueStack stack = invocation.getStack();
		//如果没有设置jsonObject，则默认使用defaultParam
		Object object;
		if (StringUtil.isNotEmpty(jsonObject))
			object = stack.findValue(jsonObject);
		else
			object = stack.findValue(defaultParam);
		
		if (object == null)
			throw new RuntimeException("expecting jsonObject , but found null!");
		
		String retStr = null;
		if (object instanceof org.json.JSONObject) 
			retStr = ((JSONObject) object).toString();
		else
			retStr = object.toString();
		
		 HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
		 
		 if (isByte) {
			 OutputStream outputStream = response.getOutputStream();
			 outputStream.write(retStr.getBytes(this.charset));
			 outputStream.flush();
		 } else {
			 PrintWriter writer = response.getWriter();
			 writer.write(retStr);
			 writer.flush();
		 }
	}

	/************************************************ Dividing Line ***************/

	public String getJsonObject() {
		return jsonObject;
	}


	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public String getCharset() {
		return charset;
	}


	public void setCharset(String charset) {
		this.charset = charset;
	}

}
