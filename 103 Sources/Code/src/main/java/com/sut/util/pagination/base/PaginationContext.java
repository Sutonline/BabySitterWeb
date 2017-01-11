/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月30日 上午10:50:28
 * cvs: $Id: $
 */
package com.sut.util.pagination.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;

/**
 * 保存分页查询时的数据及要查询的范围 
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("rawtypes")
public class PaginationContext {
	
	private static ThreadLocal tLocal = new ThreadLocal();
	
	//使用这个是我们在setPage的时候就很方便的，不需要在action中单独处理
	private static ThreadLocal<HttpServletRequest> tLocal2 = new ThreadLocal<>(); 
	 
	/**
	 * @return PaginatioinVo
	 */
	@SuppressWarnings("unchecked")
	public static PaginationVo getContext() {
		PaginationVo obj = (PaginationVo) tLocal.get();
		if (obj == null) {
			obj = new PaginationVo(0, 0, 5);
			tLocal.set(obj);
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public static void setContext(PaginationVo componentVo) {
		tLocal.set(componentVo);
		if (componentVo != null)
			tLocal2.get().setAttribute(com.sut.util.Constants.RETURN_LIST, componentVo);
	}
	
	/**
	 * 获取总数
	 * @return
	 */
	public static int getTotalNum() {
		return getContext().getFullListSize();
	}
	
	public static RowBounds getRowsBound() {
		return new RowBounds((getContext().getPageNumber() - 1 ) * getContext().getObjectsPerPage(), getContext().getObjectsPerPage());
	}

	/**
	 * 将本次分页的request绑定进来
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return tLocal2.get();
	}
	
	/**
	 * 返回本次分页请求的request
	 * @param request
	 */
	public static void setRequest(HttpServletRequest request) {
		tLocal2.set(request);
	}
}
