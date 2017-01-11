/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月27日 下午1:48:54
 * cvs: $Id: $
 */
package com.sut.web.struts.converters;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.sut.util.ConverterHelper;

/**
 * Long Converter
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("rawtypes")
public class LongConverter extends StrutsTypeConverter {

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(ConverterHelper.checkValues(values))
			return null;
		if (toClass != Long.class)
			throw new TypeConversionException(new 
					UnsupportedOperationException(getClass() + " only support java.lang.Long type ! "));
		return Long.parseLong(values[0]);
	}

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		if (o == null) 
			return null;
		if (o.getClass() != Long.class)
			throw new TypeConversionException(new 
					UnsupportedOperationException(getClass() + " only support java.lang.Long type ! "));
		
		return Long.toString((Long) o);
	}

}
