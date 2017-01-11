/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月9日 上午10:59:27
 * cvs: $Id: $
 */
package com.sut.web.struts.validators;

import com.sut.util.StringUtil;

/**
 * 
 * @author Sut
 * @version $Revision:$
 */
public class RequiredStringValidator extends com.opensymphony.xwork2.validator.validators.RequiredStringValidator {

	private String validator_js_Str = null;

	/**
	 * 获取validator_js_Str属性，然后在form-close.ftl中使用
	 * 增加到前面的
	 * @return
	 */
	public String getValidator_js_Str() {
		if (StringUtil.isNullorEmpty(validator_js_Str)) {
			StringBuffer sb = new StringBuffer();
			sb.append("if(tagType == \"radio\" || tagType == \"checkbox\"){");
			sb.append("return tagValue <= 0;");
			sb.append("else {");
			sb.append("return tagValue == \"\";}");
			
			validator_js_Str = sb.toString();
		}
		return validator_js_Str;
	}
	
	
	
}
