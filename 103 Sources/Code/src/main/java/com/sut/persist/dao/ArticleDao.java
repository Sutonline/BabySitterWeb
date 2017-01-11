/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午8:03:19
 * cvs: $Id: $
 */
package com.sut.persist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.sut.persist.entity.Article;
import com.sut.util.meta.ArticleStatusEnum;
import com.sut.util.meta.ArticleTypeEnum;

/**
 * article的操作
 * @author Sut
 * @version $Revision:$
 */
public interface ArticleDao {

	/**
	 * 保存article
	 * @param artcile
	 */
	public void insert(Article artcile);
	
	
	/**
	 * 根据类型获取article的列表
	 * 分页获取
	 * @param ate
	 * @return
	 */
	public List<Article> getByType(@Param("articleType") ArticleTypeEnum ate, RowBounds rowBounds);
	
	
	/**
	 * 获取总数，为displayTag提供总页数
	 * @param ate
	 * @param ase
	 * @param rowBounds
	 * @return
	 */
	public int getCntByTypeAndStatus(@Param("articleType") ArticleTypeEnum ate, @Param("articleStatus") ArticleStatusEnum ase);
	
	
	/**
	 * 根据类型获取某个状态的article list
	 * @param ate
	 * @param ase
	 * @return
	 */
	public List<Article> getByTypeAndStatus(@Param("articleType") ArticleTypeEnum ate, @Param("articleStatus") ArticleStatusEnum ase, RowBounds rowBounds);
	
	
	/**
	 * 更具id更新article
	 * @param article
	 */
	public void update(Article article);
	
	
	/**
	 * 删除article
	 * @param id
	 */
	public void delete(long id);
	
	/**
	 * 获取所有的article
	 */
	public void listAll();
	
	/**
	 * 获取id的article
	 * @param id
	 */
	public Article getById(long id);
	
	/**
	 * 获取About
	 * @return
	 */
	public List<Article> getAbout();
}
