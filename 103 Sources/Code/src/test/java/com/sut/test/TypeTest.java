/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月7日 上午9:22:49
 * cvs: $Id: $
 */
package com.sut.test;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.TypeHandlerRegistry;

/**
 * 用来测试泛型T都包括什么
 * @author Sut
 * @version $Revision:$
 */
public class TypeTest {
	
	public static void test() {
		System.out.println(String.class instanceof Type);
		String abc = "";
		System.out.println(abc.getClass() instanceof Type);
		List<String> list = new ArrayList<String>();
		System.out.println(list.getClass() + "的结果是: " + (list.getClass() instanceof Type));
		Class<?> clazz = Integer.class;
		System.out.println(clazz instanceof Type);
	}
	
	public static void main(String[] args) {
		test();
		try {
			Class<?> clazz = Class.forName("org.apache.ibatis.type.TypeHandlerRegistry");
			Field field = clazz.getDeclaredField("ALL_TYPE_HANDLERS_MAP");
			System.out.println(field);
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
	}

}
