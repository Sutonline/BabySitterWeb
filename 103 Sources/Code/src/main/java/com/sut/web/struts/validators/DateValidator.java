/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月9日 下午1:47:22
 * cvs: $Id: $
 */
package com.sut.web.struts.validators;

import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;
import com.sut.util.StringUtil;

/**
 * datevalidator 
 * @author Sut
 * @version $Revision:$
 */
public class DateValidator extends FieldValidatorSupport {
	
	private String dateFormat = "yyyy-MM-dd";

	/**
	 * @see com.opensymphony.xwork2.validator.Validator#validate(java.lang.Object)
	 */
	@Override
	public void validate(Object object) throws ValidationException {
		String fieldName = getFieldName();
		Object value = this.getFieldValue(fieldName, object);
		//only not null will verify
		if (value != null && StringUtil.isNotEmpty(value.toString())) {
			if (!isValidDate(value.toString()))
				addFieldError(fieldName, object);
		}
	}
	
	/**
	 * @param s
	 * @return 日期是否为所设置的类型
	 */
	private boolean isValidDate(String s) {
		try {
			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007-02-29会被接受，并转换成2007-03-01
			simpleDateFormat.setLenient(false);
			simpleDateFormat.parse(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
}
