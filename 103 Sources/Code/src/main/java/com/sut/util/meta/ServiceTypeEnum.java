/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午4:37:42
 * cvs: $Id: $
 */
package com.sut.util.meta;

import java.util.Arrays;

import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 服务类型
 * @author Sut
 * @version $Revision:$
 */
public class ServiceTypeEnum extends StringEnumTypeImp {

	private static final long serialVersionUID = 1L;
	
	/**
	 * default Constructor
	 */
	public ServiceTypeEnum(){}
	
	/**
	 * 存储值
	 * @param storeValue
	 */
	public ServiceTypeEnum(String storeValue){
		super(storeValue, ServiceTypeEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	
	/**
	 * 空值
	 */
	public static final ServiceTypeEnum NULL = new ServiceTypeEnum("");
	
	/**
	 * 新生婴儿护理
	 */
	public static final ServiceTypeEnum NEW_BIRTH_CARE = new ServiceTypeEnum("01");
	
	/**
	 * 月嫂
	 */
	public static final ServiceTypeEnum BABY_CARE = new ServiceTypeEnum("02");
	
	/**
	 * 催乳师
	 */
	public static final ServiceTypeEnum PROLACTIN = new ServiceTypeEnum("03");
	
	/**
	 * 全部枚举
	 */
	public static final ServiceTypeEnum[] ALL = {NEW_BIRTH_CARE, BABY_CARE, PROLACTIN};
	
	static{
		Arrays.sort(ALL);
	}
	
	/**
	 * @return 获取全部枚举
	 */
	public static final ServiceTypeEnum[] getAll() {
		return ALL;
	}
	
	/**
	 * 根据code获取枚举
	 * @param code
	 * @return
	 */
	public static final ServiceTypeEnum fromStringCode(final String code) {
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
	
}
