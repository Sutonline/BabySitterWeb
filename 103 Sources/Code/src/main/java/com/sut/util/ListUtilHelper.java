/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月19日 下午8:40:54
 * cvs: $Id: $
 */
package com.sut.util;

import java.util.Collection;

/**
 * List帮助类
 * @author Sut
 * @version $Revision:$
 */
public class ListUtilHelper {
	
	/**
	 * @param collection
	 * @return 返回是否为null或者为空
	 */
	public static final boolean isNullOrEmpty(Collection<?> collection) {
		if (collection == null || collection.size() <= 0)
			return true;
		else
			return false;
	}

}
