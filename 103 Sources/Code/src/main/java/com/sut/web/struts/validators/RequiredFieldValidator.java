/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月9日 上午10:31:26
 * cvs: $Id: $
 */
package com.sut.web.struts.validators;

/**
 * 必填validator
 * @author Sut
 * @version $Revision:$
 */
public class RequiredFieldValidator extends com.opensymphony.xwork2.validator.validators.RequiredFieldValidator {
	private String validator_js_Str = null;
	
	public String getValidator_js_Str() {
		if (validator_js_Str == null || "".equals(validator_js_Str)) {
			StringBuffer sb = new StringBuffer();
			sb.append("if(tagType == \"radio\" || tagType == \"checkbox\"){ ");
			sb.append("return tagValue <= 0;}");
			sb.append("else {");
			sb.append("return tagValue == ''};");
			validator_js_Str = sb.toString();
		}
			
		return validator_js_Str;
	}
	
}
