/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月27日 下午2:02:29
 * cvs: $Id: $
 */
package com.sut.web.struts.converters;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.sut.util.ConverterHelper;

/**
 * 主要是去除空格
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("rawtypes")
public class StringConverter extends StrutsTypeConverter {

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (ConverterHelper.checkValues(values)) {
			return null;
		}
		
		if (toClass != String.class) 
			throw new TypeConversionException(new 
					UnsupportedEncodingException(getClass() + " only supports java.lang.String type! "));
		
		return values[0].trim();
	}

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		if (o == null)
			return null;
		
		if (! (o instanceof String[])) {
			throw new TypeConversionException(new UnsupportedOperationException(getClass() + " only support java.lang.String!"));
		}
		String[] str = (String[]) o;
		return str[0];
	}

	
}
