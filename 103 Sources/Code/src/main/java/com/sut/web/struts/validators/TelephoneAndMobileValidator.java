/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月9日 下午2:02:02
 * cvs: $Id: $
 */
package com.sut.web.struts.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/**
 * 
 * @author Sut
 * @version $Revision:$
 */
public class TelephoneAndMobileValidator extends FieldValidatorSupport {

	/**
	 * @see com.opensymphony.xwork2.validator.Validator#validate(java.lang.Object)
	 */
	@Override
	public void validate(Object object) throws ValidationException {
		String fieldName = getFieldName();
		Object ob = super.getFieldValue(fieldName, object);
		if (ob != null & ob.toString().trim().length() > 0) {
			Pattern pattern = Pattern.compile("^(\\+\\d+)?([-]?((\\d{4}-?\\d{7,8})|(\\d{3}-?\\d{8})|(^\\d{7,8}))(-\\d+)?)|[0]?[1][3][5][8][0][0-9]{9}$", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(ob.toString());
			if (!matcher.matches()) {
				addFieldError(fieldName, object);
			}
		}
	}

}
