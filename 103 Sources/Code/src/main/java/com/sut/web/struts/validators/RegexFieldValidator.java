/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月9日 上午11:40:38
 * cvs: $Id: $
 */
package com.sut.web.struts.validators;

import com.sut.util.StringUtil;

/**
 * validator of regex
 * @author Sut
 * @version $Revision:$
 */
public class RegexFieldValidator extends com.opensymphony.xwork2.validator.validators.RegexFieldValidator {
	
	private String validator_js_Str = null;
	
	public String getValidator_js_Str() {
		if (StringUtil.isNullorEmpty(validator_js_Str)) {
			StringBuffer sb = new StringBuffer();
			sb.append("return tagValue != null && !(/^" + super.getExpression() + "$/).test(tagValue);");
			validator_js_Str = sb.toString();
		}
		
		return validator_js_Str;
	}
	
}
