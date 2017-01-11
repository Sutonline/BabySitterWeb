/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月9日 下午1:55:47
 * cvs: $Id: $
 */
package com.sut.web.struts.validators;

import java.util.Date;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/**
 * 日期比较
 * @author Sut
 * @version $Revision:$
 */
public class DateComparison extends FieldValidatorSupport {
	
	// 结束时间
	private String endDateFieldName;
	// 是否需要等于
	private boolean equal = true;

	/**
	 * @see com.opensymphony.xwork2.validator.Validator#validate(java.lang.Object)
	 */
	@Override
	public void validate(Object object) throws ValidationException {
		String beginDateFieldName = getFieldName();
		
		Date beginDate = (Date) getFieldValue(beginDateFieldName, object);
		Date endDate = null;
		if ("sysDate".equals(endDateFieldName)) {
			endDate = new Date(System.currentTimeMillis());
			endDateFieldName = beginDateFieldName;
		} else {
			endDate = (Date) getFieldValue(endDateFieldName, object);
		}
		
		if (beginDate == null || endDate == null) {
			return;
		}
		if (equal) {
			if (endDate.compareTo(beginDate) < 0) {
				addFieldError(endDateFieldName, object);
			}
		}
	}

	public void setEndDateFieldName(String endDateFieldName) {
		this.endDateFieldName = endDateFieldName;
	}

	public void setEqual(boolean equal) {
		this.equal = equal;
	}

}
