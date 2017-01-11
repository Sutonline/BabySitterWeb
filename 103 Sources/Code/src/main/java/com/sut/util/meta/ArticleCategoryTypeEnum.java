/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月22日 下午5:05:42
 * cvs: $Id: $
 */
package com.sut.util.meta;

import java.util.Arrays;

import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 文章类别
 * @author Sut
 * @version $Revision:$
 */
public class ArticleCategoryTypeEnum extends StringEnumTypeImp {
	
	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default Constructor
	 */
	public ArticleCategoryTypeEnum(){}
	
	/**
	 * 存储值
	 * @param storeValue
	 */
	public ArticleCategoryTypeEnum(String storeValue){
		super(storeValue, ArticleCategoryTypeEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	
	/**
	 * 空值
	 */
	public static final ArticleCategoryTypeEnum NULL = new ArticleCategoryTypeEnum("");
	
	/**
	 * 男
	 */
	public static final ArticleCategoryTypeEnum SERVICES = new ArticleCategoryTypeEnum("01");
	
	/**
	 * 女
	 */
	public static final ArticleCategoryTypeEnum NEWS = new ArticleCategoryTypeEnum("02");
	
	/**
	 * 全部枚举
	 */
	public static final ArticleCategoryTypeEnum[] ALL = {SERVICES, NEWS};
	
	static{
		Arrays.sort(ALL);
	}
	
	/**
	 * @return 获取全部枚举
	 */
	public static final ArticleCategoryTypeEnum[] getAll() {
		return ALL;
	}
	
	/**
	 * 根据code获取枚举
	 * @param code
	 * @return
	 */
	public static final ArticleCategoryTypeEnum fromStringCode(final String code){
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
}
