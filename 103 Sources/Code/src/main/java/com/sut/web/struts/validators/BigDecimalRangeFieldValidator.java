/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月9日 下午1:37:41
 * cvs: $Id: $
 */
package com.sut.web.struts.validators;

import java.math.BigDecimal;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/**
 * bigDecimal类型校验器，包括长度及分为的校验
 * @author Sut
 * @version $Revision:$
 */
public class BigDecimalRangeFieldValidator extends FieldValidatorSupport {

	/** 字段值的上限 **/
	private BigDecimal max;
	/** 字段值的下限 **/
	private BigDecimal min;
	/** 字段的总长度 **/
	private int length = -1;
	/** 小数位数 **/
	private int scale = -1;
	
	/**
	 * @see com.opensymphony.xwork2.validator.Validator#validate(java.lang.Object)
	 */
	@Override
	public void validate(Object object) throws ValidationException {
		Object obj = getFieldValue(getFieldName(), object);
		if (obj == null)
			return;
		if (obj instanceof BigDecimal) {
			BigDecimal value = (BigDecimal) obj;
			int int_length = 0;
			if (value.toString().indexOf(".") != -1)
				int_length = value.toString().substring(0, value.toString().indexOf(".")).length();
			else
				int_length = value.toString().length();
			if (length > -1 && (int_length > (scale > -1?(length - scale) : length))) {
				addFieldError(getFieldName(), object);
			}
			
			if (min != null && value.compareTo(min) < 0) {
				addFieldError(getFieldName(), object);
			}
			
			if (max != null && value.compareTo(max) > 0) {
				addFieldError(getFieldName(), object);
			}
		}
	}
	
}
