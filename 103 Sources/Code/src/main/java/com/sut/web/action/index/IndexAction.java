package com.sut.web.action.index;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.opensymphony.xwork2.ActionSupport;
import com.sut.persist.dao.UserDao;
import com.sut.persist.entity.Article;
import com.sut.persist.entity.User;
import com.sut.service.ArticleService;
import com.sut.util.meta.ArticleStatusEnum;
import com.sut.util.meta.ArticleTypeEnum;

/**
 * index Action
 * @author sut
 * @Created 2016年9月17日
 */
@SuppressWarnings("serial")
public class IndexAction extends ActionSupport{
	
	
	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);

	/* 注入service */
	private UserDao userDao;
	private ArticleService articleService;
	
	//返回结果
	private List<Article> newsList;
	
	/**
	 * @return
	 */
	public String index(){
		logger.info("进入index()方法");
		/*User user = new User();
		user.setUsername("测试1");
		user.setPassword("ineedthink");
		user.setEnable(WhetherTypeEnum.YES);
		user.setCreateTime(new java.util.Date());
		user.setLastLoginDate(new java.util.Date());
		user.setSex(SexTypeEnum.MAN);
		user.setEmail("84526333@qq.com");
		user.setMobile("131212699dd");
		user.setProvince("浙江省");
		user.setCity("杭州市");
		user.setArea("江干区");
		user.setAddress("秋涛路660号浙江农信大厦");
		user.setRemark("no Remark");
		userDao.insert(user);*/
		try {
			List<User> list = userDao.getAll();
			logger.info(list.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 返回主页头部
	 * @return
	 */
	public String header(){
		return SUCCESS;
	}
	
	/**
	 * 返回主页Foot
	 * @return
	 */
	public String footer(){
		return SUCCESS;
	}
	
	/**
	 * 返回主页
	 * @return
	 */
	public String mainport(){
		//1. 获取新闻资讯前5条
		List<Article> list = articleService.getByTypeAndStatus(ArticleTypeEnum.NEWS, ArticleStatusEnum.APPROVED);
		if (list != null && list.size() >= 5)
			newsList = Lists.partition(list, 5).get(0);
		else 
			newsList = list;
		
		
		return SUCCESS;
	}
	
	
	
	/*************************************** Dividing Line *********************/

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public List<Article> getNewsList() {
		return newsList;
	}
	
}
