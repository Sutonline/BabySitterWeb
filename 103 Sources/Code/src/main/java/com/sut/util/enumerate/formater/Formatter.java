/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午2:16:54
 * cvs: $Id: $
 */
package com.sut.util.enumerate.formater;

/**
 * 格式化器 
 * @author sut
 * @version $Revision:$
 */
public interface Formatter {

	/**
	 * 输出格式化对象
	 * @param object
	 * @return 格式化文本
	 */
	String format(Object object);
	
	/**
	 * 将object输出到StringBuffer中
	 * @param object
	 * @param out
	 */
	void format(Object object, StringBuffer out);
}
