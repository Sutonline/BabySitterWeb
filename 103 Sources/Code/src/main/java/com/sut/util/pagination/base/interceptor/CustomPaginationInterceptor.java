/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月30日 上午11:03:45
 * cvs: $Id: $
 */
package com.sut.util.pagination.base.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sut.util.StringUtil;
import com.sut.util.pagination.base.PaginationContext;
import com.sut.util.pagination.base.PaginationVo;

/**
 * 自定义分页 
 * @author Sut
 * @version $Revision:$
 */
public class CustomPaginationInterceptor extends AbstractInterceptor {

	private static Logger LOG = LoggerFactory.getLogger(CustomPaginationInterceptor.class);
	private static final long serialVersionUID = 1L;
	
	/**
	 * action执行后执行,将数据设置进去即可
	 * 统一使用retList表示
	 * @param dispathcer
	 * @param result
	 * @throws Exception
	 */
	protected void after(ActionInvocation dispathcer, String result) throws Exception {
		LOG.debug("处理完毕!");
		PaginationContext.setContext(null);
		PaginationContext.setRequest(null);
	}
	
	/**
	 * action执行前执行,主要用来处理request获取页数
	 * @param invocation
	 * @throws Exception
	 */
	protected void before(ActionInvocation invocation)  throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		PaginationContext.setRequest(request);
		String  s = request.getParameter("page");
		PaginationVo pageVo = PaginationContext.getContext();
		if (StringUtil.isNullorEmpty(s))
			pageVo.setPageNumber(1);
		else 
			pageVo.setPageNumber(Integer.parseInt(s));
	}
	
	/**
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null;
		before(invocation);
		result = invocation.invoke();
		after(invocation, result);
		
		return result;
	}

}
