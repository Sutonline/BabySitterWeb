/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月27日 下午1:43:07
 * cvs: $Id: $
 */
package com.sut.web.struts.converters;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * TODO plz add Comments
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("rawtypes")
public class BooleanConverter extends StrutsTypeConverter {

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (toClass != Boolean.class) {
			throw new TypeConversionException(new UnsupportedOperationException(getClass() + "only support java.lang.Boolean Type!"));
		}
		
		if (values == null || values.length == 0 || "".equals(values[0])){
			return null;
		}
		
		return Boolean.valueOf(values[0]);
	}

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		if (o == null)
			return null;
		
		if (! (o instanceof Boolean)) {
			throw new TypeConversionException(new UnsupportedOperationException(getClass() + "only support java.lang.Boolean Type!"));
		}
		
		return Boolean.toString((Boolean) o);
	}

}
