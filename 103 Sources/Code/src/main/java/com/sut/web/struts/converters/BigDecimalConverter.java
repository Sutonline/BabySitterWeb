/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月27日 下午2:10:44
 * cvs: $Id: $
 */
package com.sut.web.struts.converters;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.sut.util.ConverterHelper;

/**
 * BigDecimalConverter
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("rawtypes")
public class BigDecimalConverter extends StrutsTypeConverter {

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (toClass != BigDecimal.class) 
			throw new TypeConversionException(new 
					UnsupportedOperationException(getClass() + " only supports java.math.BigDecimal type! "));
		
		if (ConverterHelper.checkValues(values)) 
			return null;
		
		try {
			String input = values[0];
			String replaceInput = input.replaceAll(",", "");
			return new BigDecimal(replaceInput);
		} catch (NumberFormatException e) {
			throw new TypeConversionException(new 
					UnsupportedOperationException("Cann't convert " + values[0] + " to java.math.BigDecimal "));
		}
	}

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		if (o == null)
			return null;
		
		if (! (o instanceof BigDecimal)) {
			throw new TypeConversionException(new UnsupportedOperationException(getClass() + " only support java.math.BigDecimal type!"));
		}
		
		BigDecimal outputData = (BigDecimal) o;
		StringBuffer formatString = new StringBuffer("#,###,###,###,###,###");
		if (outputData.doubleValue() >= 1 || outputData.doubleValue() <= -1) 
			if (outputData.scale() > 0 && outputData.doubleValue() != 0) {
				formatString.append(".");
				for (int i = 0; i < outputData.scale(); i++) {
					formatString.append("0");
				}
			}
		if (outputData.doubleValue() >= 1 || outputData.doubleValue() <= -1) {
			DecimalFormat fmt = new DecimalFormat(formatString.toString());
			return fmt.format((BigDecimal) o);
		}
		
		return outputData.toString();
	}

}
