/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月27日 下午1:52:05
 * cvs: $Id: $
 */
package com.sut.util;

/**
 * Converter帮助类
 * @author Sut
 * @version $Revision:$
 */
public class ConverterHelper {

	/**
	 * @param values
	 * @return 检查values是否有值
	 */
	public static boolean checkValues(String[] values) {
		if (values == null || values.length <= 0 || values[0] == null || values[0].equals(""))
			return true;
		return false;
	}
	
}
