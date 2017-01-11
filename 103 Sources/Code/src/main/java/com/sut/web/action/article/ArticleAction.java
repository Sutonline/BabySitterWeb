package com.sut.web.action.article;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.sut.persist.entity.Article;
import com.sut.service.ArticleService;
import com.sut.util.meta.ArticleStatusEnum;
import com.sut.util.meta.ArticleTypeEnum;
import com.sut.util.pagination.base.PaginationVo;
import com.sut.web.action.Execution;

/**
 * TODO 保存article的时候需要默认值
 * Article Action
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("serial")
public class ArticleAction extends Execution {
	
	private static final Logger LOG = LoggerFactory.getLogger(ArticleAction.class);
	
	//注入service
	
	private ArticleService articleService;
	
	//前台传参
	private Article article;
	private ArticleTypeEnum articleType;
	
	//返回结果
	private List<Article> list;
	private PaginationVo paginationVo;
	
	/**
	 * @return 根据类别获取所有的文章
	 */
	public String listByCategory() {
		return SUCCESS;
	}
	
	/**
	 * 保存article
	 * @return
	 */
	public String saveArticle() {
		LOG.info("接受前台的article,用来保存");
		if (article == null)
			return SUCCESS;
		
		article.setAuthor("admin");
		article.setPublishTime(new java.util.Date());
		article.setTimeStamp(new java.util.Date());
		//现在默认都设置为审核通
		article.setArticleStatus(ArticleStatusEnum.APPROVED);
		
		LOG.info("保存article" + article.toString());
		
		articleService.saveArticle(article);
		return SUCCESS;
	}
	
	/**
	 * @param articleId
	 * @return 编辑文章
	 */
	public String edit() {
		return SUCCESS;
	}
	
	/**
	 * @return 新增文章
	 */
	public String newArticle() {
		return SUCCESS;
	}
	
	/**
	 * @return 返回首页的article
	 */
	public String getAboutArticle() {
		this.article = articleService.getAboutArticle();
		return SUCCESS;
	}

	/**
	 * 返回新闻
	 * @return
	 */
	public String getNews() {
		this.paginationVo = articleService.getArticleListByPage(ArticleTypeEnum.NEWS, ArticleStatusEnum.APPROVED); 
		LOG.info("获取成功!");
		return SUCCESS;
	}
	
	/**
	 * 根据id获取文章详情
	 * @return
	 */
	public String getDetail() {
		LOG.info("要获取的id为: " + article.getId());
		Preconditions.checkNotNull(article.getId(), "id为空，不能获取!");
		this.article = articleService.getById(article.getId());
		return SUCCESS;
	}
	/********************** Following are getters and setters ******************/
	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public ArticleTypeEnum getArticleType() {
		return articleType;
	}

	public void setArticleType(ArticleTypeEnum articleType) {
		this.articleType = articleType;
	}

	public List<Article> getList() {
		return list;
	}

	public void setList(List<Article> list) {
		this.list = list;
	}

	public PaginationVo getPaginationVo() {
		return paginationVo;
	}
}
