/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午3:36:06
 * cvs: $Id: $
 */
package com.sut.util.meta;

import java.util.Arrays;

import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 文章类别枚举
 * @author Sut
 * @version $Revision:$
 */
public class ArticleTypeEnum extends StringEnumTypeImp {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default Constructor
	 */
	public ArticleTypeEnum(){}
	
	/**
	 * 存储值
	 * @param storeValue
	 */
	public ArticleTypeEnum(String storeValue){
		super(storeValue, ArticleTypeEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	
	/**
	 * 空值
	 */
	public static final ArticleTypeEnum NULL = new ArticleTypeEnum("");
	
	/**
	 * 新闻
	 */
	public static final ArticleTypeEnum NEWS = new ArticleTypeEnum("01");
	
	/**
	 * 服务
	 */
	public static final ArticleTypeEnum SERVICES = new ArticleTypeEnum("02");
	
	/**
	 * 清洗文章
	 */
	public static final ArticleTypeEnum AR_CLEANING = new ArticleTypeEnum("03");
	
	/**
	 * 医疗知识
	 */
	public static final ArticleTypeEnum AR_KNOWLEDGE = new ArticleTypeEnum("04");
	
	/**
	 * 经验分享
	 */
	public static final ArticleTypeEnum AR_EXPERIENCE = new ArticleTypeEnum("05");
	
	/**
	 * 关于我们
	 */
	public static final ArticleTypeEnum ABOUT_US = new ArticleTypeEnum("06");
	
	/**
	 * 全部枚举
	 */
	public static final ArticleTypeEnum[] ALL = {NEWS, SERVICES, AR_CLEANING, AR_KNOWLEDGE, AR_EXPERIENCE, ABOUT_US};
	
	static{
		Arrays.sort(ALL);
	}
	
	/**
	 * @return 获取全部枚举
	 */
	public static final ArticleTypeEnum[] getAll() {
		return ALL;
	}
	
	/**
	 * 根据code获取枚举
	 * @param code
	 * @return
	 */
	public static final ArticleTypeEnum fromStringCode(final String code){
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
	
	
}
