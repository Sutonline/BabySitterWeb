/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月9日 上午11:25:31
 * cvs: $Id: $
 */
package com.sut.web.struts.validators;

import com.sut.util.StringUtil;

/**
 * 
 * @author Sut
 * @version $Revision:$
 */
public class IntRangeFieldValidator extends com.opensymphony.xwork2.validator.validators.IntRangeFieldValidator {

	private String validator_js_Str = null;

	public String getValidator_js_Str() {
		if (this.getMin() != null || this.getMax() != null) {
			if (StringUtil.isNullorEmpty(validator_js_Str)) {
				StringBuffer sb = new StringBuffer();
				sb.append("return (1!=1 ");
				if (this.getMin() != null) {
					sb.append(" || tagValue < " + this.getMin().intValue());
				}
				if (this.getMax() != null ) {
					sb.append(" || tagValue > " + this.getMax().intValue());
				}
				sb.append(");");
				validator_js_Str = sb.toString();
			}
		}
		
		return validator_js_Str;
	}
	
	
	
}
