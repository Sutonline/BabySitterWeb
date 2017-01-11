/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月8日 下午6:14:41
 * cvs: $Id: $
 */
package com.sut.web.action.customerServicve;

import com.sut.service.ArticleService;
import com.sut.web.action.Execution;

/**
 * TODO plz add Comments
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("serial")
public class CustomerServiceAction extends Execution {

	private ArticleService articleService;
	
	/**
	 * @return 返回服务列表
	 */
	public String serviceList() {
		return SUCCESS;
	}
	
	/**
	 * @return 返回服务详细内容(使用articleService进行获取)
	 */
	public String serviceDetail() {
		return SUCCESS;
	}

	/********************************************* Dividing Line ***************************************/
	
	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
}
