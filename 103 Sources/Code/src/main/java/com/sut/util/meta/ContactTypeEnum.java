/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月10日 上午11:34:51
 * cvs: $Id: $
 */
package com.sut.util.meta;

import java.util.Arrays;

import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 联系方式
 * @author Sut
 * @version $Revision:$
 */
public class ContactTypeEnum extends StringEnumTypeImp {
	

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default Constructor
	 */
	public ContactTypeEnum(){}
	
	/**
	 * 存储值
	 * @param storeValue
	 */
	public ContactTypeEnum(String storeValue){
		super(storeValue, ContactTypeEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	
	/**
	 * 空值
	 */
	public static final ContactTypeEnum NULL = new ContactTypeEnum("");
	
	/**
	 * 手机
	 */
	public static final ContactTypeEnum MOBILE = new ContactTypeEnum("01");
	
	/**
	 * QQ
	 */
	public static final ContactTypeEnum QQ = new ContactTypeEnum("02");
	
	/**
	 * 微信
	 */
	public static final ContactTypeEnum WEBCHAT = new ContactTypeEnum("03");
	
	
	/**
	 * 全部枚举
	 */
	public static final ContactTypeEnum[] ALL = {MOBILE, QQ, WEBCHAT};
	
	static{
		Arrays.sort(ALL);
	}
	
	/**
	 * @return 获取全部枚举
	 */
	public static final ContactTypeEnum[] getAll() {
		return ALL;
	}
	
	/**
	 * 根据code获取枚举
	 * @param code
	 * @return
	 */
	public static final ContactTypeEnum fromStringCode(final String code){
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
	
}
