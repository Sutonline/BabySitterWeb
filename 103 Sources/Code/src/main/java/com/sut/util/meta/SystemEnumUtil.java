/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午1:48:07
 * cvs: $Id: $
 */
package com.sut.util.meta;

import com.sut.util.enumerate.base.MessageResource;
import com.sut.util.enumerate.base.ResourceGetter;

/**
 * 
 * @author sut
 * @version $Revision:$
 */
public class SystemEnumUtil {

	private SystemEnumUtil() {
		
	}
	
	static MessageResource resource = new ResourceGetter(SystemEnumUtil.class.getSimpleName(),
			SystemEnumUtil.class.getClassLoader());
	
}
