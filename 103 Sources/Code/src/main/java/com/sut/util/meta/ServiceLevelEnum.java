/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午4:46:54
 * cvs: $Id: $
 */
package com.sut.util.meta;

import java.util.Arrays;

import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 职工级别 
 * @author Sut
 * @version $Revision:$
 */
public class ServiceLevelEnum extends StringEnumTypeImp {

	private static final long serialVersionUID = 1L;
	
	/**
	 * default Constructor
	 */
	public ServiceLevelEnum(){}
	
	/**
	 * 存储值
	 * @param storeValue
	 */
	public ServiceLevelEnum(String storeValue){
		super(storeValue, ServiceLevelEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	
	/**
	 * 空值
	 */
	public static final ServiceLevelEnum NULL = new ServiceLevelEnum("");
	
	/**
	 * 初级
	 */
	public static final ServiceLevelEnum PRIMARY_LEVEL = new ServiceLevelEnum("01");
	
	/**
	 * 中级
	 */
	public static final ServiceLevelEnum MIDDLE_LEVEL = new ServiceLevelEnum("02");
	
	/**
	 * 高级
	 */
	public static final ServiceLevelEnum SENIOR_LEVEL = new ServiceLevelEnum("03");
	
	/**
	 * 特级
	 */
	public static final ServiceLevelEnum SPECIAL_LEVEL = new ServiceLevelEnum("04");
	
	/**
	 * 全部枚举
	 */
	public static final ServiceLevelEnum[] ALL = {PRIMARY_LEVEL, MIDDLE_LEVEL, SENIOR_LEVEL, SPECIAL_LEVEL};
	
	static{
		Arrays.sort(ALL);
	}
	
	/**
	 * @return 获取全部枚举
	 */
	public static final ServiceLevelEnum[] getAll() {
		return ALL;
	}
	
	/**
	 * 根据code获取枚举
	 * @param code
	 * @return
	 */
	public static final ServiceLevelEnum fromStringCode(final String code){
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
	
	
}
