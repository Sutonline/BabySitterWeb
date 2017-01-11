/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月27日 上午10:15:48
 * cvs: $Id: $
 */
package com.sut.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sut.util.enumerate.base.StringEnumTypeImp;
import com.sut.util.meta.SexTypeEnum;

/**
 * Introspector get example
 * @author Sut
 * @version $Revision:$
 */
public class GetBeanInfoTest {

	public static void test(Class<?> clazz) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BeanInfo beaninfo = null;
		try {
			beaninfo = Introspector.getBeanInfo(clazz);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		MethodDescriptor[] methodDescriptors = beaninfo.getMethodDescriptors();
		for (MethodDescriptor m : methodDescriptors) {
			System.out.println(m.getName());
		}
		StringEnumTypeImp seti = SexTypeEnum.MAN;
		Method method = seti.getClass().getMethod("fromStringCode", String.class);
		System.out.println(method.invoke(null, "01"));
	}
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		test(com.sut.util.meta.ArticleTypeEnum.class);
	}
	
}
