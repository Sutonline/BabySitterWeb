/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月27日 上午9:09:24
 * cvs: $Id: $
 */
package com.sut.web.struts.converters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * Enum的转换
 * <ul>
 * 	<li>思路一: 在初始化的时候保存到缓存中，然后给一个type -> value -> enum 适用于guava 的table
 *  <li>思路二: 在转换的时候由Struts获取要转换类型的真正type，而不是一个所继承的父类。然后使用反射获取某个method进行调用
 * <ul>
 * @author Sut
 * @version $Revision:$
 */
public class EnumConverter extends StrutsTypeConverter {
	
	private static final Logger log = LoggerFactory.getLogger(EnumConverter.class);
	
	private static final String GET_METHOD = "fromStringCode";

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values == null)
			return null;
		
		//supports check
		if (!supportCheck(String.class, toClass, true))
			throw new UnsupportedOperationException(
					String.format("unspported conversion from %s to %s", String.class, toClass));
		
		try {
			return doConvert(values[0], toClass, true);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public String convertToString(Map context, Object o) {
		if (o == null)
			return null;
		//supports check
		if (!supportCheck(o.getClass(), String.class, false))
			throw new UnsupportedOperationException(
					String.format("unspported conversion from %s to %s", o.getClass(), String.class));
		
		try {
			return (String) doConvert(o, String.class, false);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	/**
	 * 正向和反向检查<br>
	 * 正向: Enum -> String
	 * 反向: String -> Enum
	 * @param from
	 * @param to
	 * @return 是否支持的类型转换
	 */
	private boolean supportCheck(Class<?> from, Class<?> to, boolean isRerverse) {
		if (to == null) throw new IllegalArgumentException("Arguments toClass must not null");
		if (isRerverse) {
			if (String.class.isAssignableFrom(from) && StringEnumTypeImp.class.isAssignableFrom(to)) return true;
		} else {
			if (StringEnumTypeImp.class.isAssignableFrom(from) && String.class.isAssignableFrom(to)) return true;
		}
		
		return false;
	}
	
	/**
	 * @param value
	 * @param toClass
	 * @return 具体的类型转换
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private Object doConvert(Object value, Class<?> toClass, boolean isRerverse) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (value == null)
			throw new IllegalArgumentException("Arguments toClass must not null");
		
		if (isRerverse) {
			log.debug("Converting string to enum...");
			String s = (String) value;
			Method method = toClass.getMethod(GET_METHOD, String.class);
			if (method == null)
				throw new TypeConversionException(String.format("Enum class must contains %s", GET_METHOD));
			return method.invoke(null, s);
		} else {
			log.debug("Converting enum to string...");
			StringEnumTypeImp stei = (StringEnumTypeImp) value;
			return stei.getStringValue();
		}
	}
	
}
