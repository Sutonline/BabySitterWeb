/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月9日 上午11:34:27
 * cvs: $Id: $
 */
package com.sut.web.struts.validators;

import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/**
 * 
 * @author Sut
 * @version $Revision:$
 */
public class StringByteLengthFieldValidator extends FieldValidatorSupport {
	
	private boolean doTrim = true;
	
	private int maxLength = -1;
	
	private int minLength = -1;
	
	private String charsetName = "UTF-8";

	/**
	 * @see com.opensymphony.xwork2.validator.Validator#validate(java.lang.Object)
	 */
	@Override
	public void validate(Object object) throws ValidationException {
		String fieldName = getFieldName();
		String val = (String) getFieldValue(fieldName, object);
		
		if (val == null) {
			//use a required validator for these
			return;
		}
		
		if (doTrim) {
			val = val.trim();
		}
		
		try {
			if ((minLength > -1) && val.getBytes(charsetName).length < minLength ) {
				addFieldError(fieldName, object);
			} else if ((maxLength > -1) && val.getBytes(charsetName).length > maxLength) {
				addFieldError(fieldName, object);
			}
		} catch (UnsupportedEncodingException e) {
			throw new ValidationException(e.getMessage());
		}
	}

	public boolean isDoTrim() {
		return doTrim;
	}

	public void setDoTrim(boolean doTrim) {
		this.doTrim = doTrim;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public String getCharsetName() {
		return charsetName;
	}

	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}
	
	
	
}
