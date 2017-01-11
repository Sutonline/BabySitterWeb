/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月27日 下午2:34:22
 * cvs: $Id: $
 */
package com.sut.web.struts.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * Date Converter
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("rawtypes")
public class DateConverter extends StrutsTypeConverter {

	private static final String DEFAULT_DATE_PATTERN_ARR[] = {"yyyy-MM-dd", "yyyyMMdd"};
	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	private static final Date DEFAULT_VALUE = null;
	private String datePattern;
	private Date defaultValue;
	
	public DateConverter() {
		this.datePattern = DEFAULT_DATE_PATTERN;
		this.defaultValue = DEFAULT_VALUE;
	}
	
	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (toClass != java.util.Date.class)
			throw new TypeConversionException(new 
					UnsupportedOperationException(getClass() + " only support java.util.Date Type!"));
		
		if (values == null || values.length == 0)
			return this.defaultValue;
		
		String dateValue =  values[0];
		if (StringUtils.isEmptyOrWhitespaceOnly(dateValue))
			return defaultValue;
		
		datePattern = null;
		
		for(String patt : DEFAULT_DATE_PATTERN_ARR) {
			if (dateValue.length() == patt.length()) {
				datePattern = patt;
				break;
			}
		}
		
		if (datePattern == null)
			throw new TypeConversionException(new 
					UnsupportedOperationException("Can't convert " + dateValue + " to java.util.Date in using format : yyyy-MM-dd or yyyyMMdd!"));
		
		try {
			DateFormat df = new SimpleDateFormat(datePattern);
			df.setLenient(false);
			return df.parseObject(dateValue);
		} catch (Exception e) {
			throw new TypeConversionException("Can't convert " + dateValue + "to java.util.Date in using format : yyyy-MM-dd or yyyyMMdd!");
		}
	}

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		if (o == null)
			return null;
		
		if (! (o instanceof Date)) {
			throw new TypeConversionException(new UnsupportedOperationException(getClass() + " only support java.util.Date Type!"));
		}
		
		return new SimpleDateFormat(DEFAULT_DATE_PATTERN).format((Date) o);
	}




	public String getDatePattern() {
		return datePattern;
	}




	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}




	public Date getDefaultValue() {
		return defaultValue;
	}




	public void setDefaultValue(Date defaultValue) {
		this.defaultValue = defaultValue;
	}

}
