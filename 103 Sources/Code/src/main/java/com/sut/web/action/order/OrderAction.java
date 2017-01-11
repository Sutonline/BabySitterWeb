/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月9日 下午8:59:24
 * cvs: $Id: $
 */
package com.sut.web.action.order;

import com.sut.web.action.Execution;

/**
 * Order Action 
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("serial")
public class OrderAction extends Execution {

	
	/**
	 * 返回order页面
	 * @return
	 */
	public String order() {
		return SUCCESS;
	}
	
}
