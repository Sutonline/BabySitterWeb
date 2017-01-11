/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月30日 下午3:44:30
 * cvs: $Id: $
 */
package com.sut.web.struts.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 用来打印exception和其他内容
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("serial")
public class ExceptionInterceptor implements Interceptor {
	
	private static Logger LOG = LoggerFactory.getLogger(ExceptionInterceptor.class);

	/**
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	@Override
	public void destroy() {

	}

	/**
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	@Override
	public void init() {

	}

	/**
	 * 只做了简单的exception捕获，然后打印
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object obj = invocation.getAction();
		try {
			
			return invocation.invoke();
		} catch (DataAccessException ex) {
			LOG.error("Error occured of DataAccessException");
			LOG.error("Can't execute action " + obj, ex);
			throw ex;
		} catch (Exception e) {
			LOG.error("Can't execute action " + obj, e);
			throw e;
		}
		
	}

}
