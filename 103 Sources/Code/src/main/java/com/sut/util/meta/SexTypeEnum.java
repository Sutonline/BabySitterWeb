/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月23日 下午5:11:07
 * cvs: $Id: $
 */
package com.sut.util.meta;

import java.util.Arrays;

import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 性别枚举 
 * @author sut
 * @version $Revision:$
 */
public class SexTypeEnum extends StringEnumTypeImp {
	
	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default Constructor
	 */
	public SexTypeEnum(){}
	
	/**
	 * 存储值
	 * @param storeValue
	 */
	public SexTypeEnum(String storeValue){
		super(storeValue, SexTypeEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	
	/**
	 * 空值
	 */
	public static final SexTypeEnum NULL = new SexTypeEnum("");
	
	/**
	 * 男
	 */
	public static final SexTypeEnum MAN = new SexTypeEnum("01");
	
	/**
	 * 女
	 */
	public static final SexTypeEnum WOMEN = new SexTypeEnum("02");
	
	/**
	 * 全部枚举
	 */
	public static final SexTypeEnum[] ALL = {MAN, WOMEN};
	
	static{
		Arrays.sort(ALL);
	}
	
	/**
	 * @return 获取全部枚举
	 */
	public static final SexTypeEnum[] getAll() {
		return ALL;
	}
	
	/**
	 * 根据code获取枚举
	 * @param code
	 * @return
	 */
	public static final SexTypeEnum fromStringCode(final String code) {
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
	
	
}
