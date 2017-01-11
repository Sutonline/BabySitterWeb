/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午1:45:07
 * cvs: $Id: $
 */
package com.sut.util.meta;

import java.util.Arrays;

import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 是否枚举
 * @author sut
 * @version $Revision:$
 */
public class WhetherTypeEnum extends StringEnumTypeImp {

	/**
	 * generate serialVersionUID
	 */
	private static final long serialVersionUID = -8494324936367838926L;

	
	/**
	 * default Constructor
	 */
	public WhetherTypeEnum(){
	}
	
	public WhetherTypeEnum(String storeValue){
		super(storeValue, WhetherTypeEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	/**
	 * 空值状态
	 */
	public static final WhetherTypeEnum NULL = new WhetherTypeEnum("");
	
	/**
	 * 否
	 */
	public static final WhetherTypeEnum NO = new WhetherTypeEnum("00");
	
	/**
	 * 是
	 */
	public static final WhetherTypeEnum YES = new WhetherTypeEnum("01");
	
	/**
	 * 全部枚举
	 */
	public static final WhetherTypeEnum[] ALL = {NO, YES};
	
	static{
		Arrays.sort(ALL);
	}
	
	public static WhetherTypeEnum[] getAll(){
		return ALL;
	}

	public static final WhetherTypeEnum fromStringCode(final String code){
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
}
