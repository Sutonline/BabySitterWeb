/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月29日 上午9:07:13
 * cvs: $Id: $
 */
package com.sut.util.meta;

import java.util.Arrays;

import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 文章状态
 * @author Sut
 * @version $Revision:$
 */
public class ArticleStatusEnum extends StringEnumTypeImp {

	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default Constructor
	 */
	public ArticleStatusEnum(){}
	
	/**
	 * 存储值
	 * @param storeValue
	 */
	public ArticleStatusEnum(String storeValue){
		super(storeValue, ArticleStatusEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	
	/**
	 * 空值
	 */
	public static final ArticleStatusEnum NULL = new ArticleStatusEnum("");
	
	/**
	 * 待审核
	 */
	public static final ArticleStatusEnum UNCHECKED = new ArticleStatusEnum("01");
	
	/**
	 * 审核通过
	 */
	public static final ArticleStatusEnum APPROVED = new ArticleStatusEnum("02");
	
	/**
	 * 审核未通过
	 */
	public static final ArticleStatusEnum REFUSED = new ArticleStatusEnum("03");
	
	/**
	 * 全部枚举
	 */
	public static final ArticleStatusEnum[] ALL = {UNCHECKED, APPROVED, REFUSED};
	
	static{
		Arrays.sort(ALL);
	}
	
	/**
	 * @return 获取全部枚举
	 */
	public static final ArticleStatusEnum[] getAll() {
		return ALL;
	}
	
	/**
	 * 根据code获取枚举
	 * @param code
	 * @return
	 */
	public static final ArticleStatusEnum fromStringCode(final String code){
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
	
	
	
}
