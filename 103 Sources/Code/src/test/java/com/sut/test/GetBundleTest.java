/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午9:31:37
 * cvs: $Id: $
 */
package com.sut.test;

import java.util.ResourceBundle;

import com.sut.util.LocaleUtil;
import com.sut.util.meta.SystemEnumUtil;

/**
 * get bundle classloader test 
 * @author Sut
 * @version $Revision:$
 */
public class GetBundleTest {

	public static void test() {
		ResourceBundle rb = ResourceBundle.getBundle(SystemEnumUtil.class.getSimpleName(), 
				LocaleUtil.getCurrentLocale(true), GetBundleTest.class.getClassLoader());
		if (rb != null)
			System.out.println(rb.getObject("com.sut.util.meta.ArticleTypeEnum.01"));
	}
	
	public static void main(String[] args) {
		test();
	}
}
