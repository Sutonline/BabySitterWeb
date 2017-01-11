/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午8:44:12
 * cvs: $Id: $
 */
package com.sut.service;

import java.util.List;

import com.sut.persist.entity.Article;
import com.sut.util.meta.ArticleStatusEnum;
import com.sut.util.meta.ArticleTypeEnum;
import com.sut.util.pagination.base.PaginationVo;

/**
 * article Service 
 * @author Sut
 * @version $Revision:$
 */
public interface ArticleService {

	/**
	 * 保存article
	 * @param article
	 */
	public void saveArticle(Article article);
	
	/**
	 * @return 获取about的内容
	 */
	public Article getAboutArticle();
	
	/**
	 * 根据类型和状态获取分页结果集
	 * @param ate
	 * @param ase
	 * @return
	 */
	public PaginationVo getArticleListByPage(ArticleTypeEnum ate, ArticleStatusEnum ase);
	
	/**
	 * @param id
	 * @return 对应id的article
	 */
	public Article getById(long id);
	
	/**
	 * @param ate
	 * @param ase
	 * @return 返回文章列表
	 */
	public List<Article> getByTypeAndStatus(ArticleTypeEnum ate, ArticleStatusEnum ase);
}
