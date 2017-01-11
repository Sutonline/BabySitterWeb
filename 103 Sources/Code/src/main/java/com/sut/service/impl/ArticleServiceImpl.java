/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午8:45:58
 * cvs: $Id: $
 */
package com.sut.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sut.persist.dao.ArticleDao;
import com.sut.persist.entity.Article;
import com.sut.service.ArticleService;
import com.sut.util.ListUtilHelper;
import com.sut.util.meta.ArticleStatusEnum;
import com.sut.util.meta.ArticleTypeEnum;
import com.sut.util.pagination.base.PaginationContext;
import com.sut.util.pagination.base.PaginationVo;

/**
 * 文章实现类
 * @author Sut
 * @version $Revision:$
 */
public class ArticleServiceImpl implements ArticleService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	private ArticleDao articleDao;

	/**
	 * @see com.sut.service.ArticleService#saveArticle(com.sut.persist.entity.Article)
	 */
	@Override
	public void saveArticle(Article article) {
		articleDao.insert(article);
	}

	/**
	 * return about article
	 * @see com.sut.service.ArticleService#getAboutArticle()
	 */
	public Article getAboutArticle() {
		List<Article> articleList = articleDao.getAbout();
		if (ListUtilHelper.isNullOrEmpty(articleList))
			return null;
		
		return articleList.get(0);
	}
	
	
	/**
	 * @see com.sut.service.ArticleService#getArticleListByPage(com.sut.util.meta.ArticleTypeEnum, com.sut.util.meta.ArticleStatusEnum)
	 */
	public PaginationVo getArticleListByPage(ArticleTypeEnum ate, ArticleStatusEnum ase) {
		PaginationVo page = PaginationContext.getContext();
		int totalCnt = articleDao.getCntByTypeAndStatus(ate, ase);
		page.setFullListSize(totalCnt);
		if (totalCnt > 0) {
			page.setList(articleDao.getByTypeAndStatus(ate, ase, PaginationContext.getRowsBound()));
			PaginationContext.setContext(page);
			LOG.debug("获取一共{}条数据", page.getList().size());
		}
		
		return page;
	}
	
	/**
	 * @see com.sut.service.ArticleService#getById(long)
	 */
	@Override
	public Article getById(long id) {
		return articleDao.getById(id);
	}
	
	
	/**
	 * @see com.sut.service.ArticleService#getByTypeAndStatus(com.sut.util.meta.ArticleTypeEnum, com.sut.util.meta.ArticleStatusEnum)
	 */
	@Override
	public List<Article> getByTypeAndStatus(ArticleTypeEnum ate, ArticleStatusEnum ase) {
		return articleDao.getByTypeAndStatus(ate, ase, new RowBounds(0, Integer.MAX_VALUE));
	}
	/***************************** Following are getters and setters ***********/
	
	public ArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

}
