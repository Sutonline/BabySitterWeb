/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午3:59:41
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
public class StaffLevelEnum extends StringEnumTypeImp {

	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default Constructor
	 */
	public StaffLevelEnum(){}
	
	/**
	 * 存储值
	 * @param storeValue
	 */
	public StaffLevelEnum(String storeValue){
		super(storeValue, StaffLevelEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	
	/**
	 * 空值
	 */
	public static final StaffLevelEnum NULL = new StaffLevelEnum("");
	
	/**
	 * 初级
	 */
	public static final StaffLevelEnum PRIMARY_LEVEL = new StaffLevelEnum("01");
	
	/**
	 * 中级
	 */
	public static final StaffLevelEnum MIDDILE_LEVEL = new StaffLevelEnum("02");
	
	/**
	 * 高级
	 */
	public static final StaffLevelEnum SENIOR_LEVEL = new StaffLevelEnum("03");
	
	/**
	 * 特级
	 */
	public static final StaffLevelEnum SPECIAL_LEVEL = new StaffLevelEnum("04");
	
	/**
	 * 全部枚举
	 */
	public static final StaffLevelEnum[] ALL = {PRIMARY_LEVEL, MIDDILE_LEVEL, SENIOR_LEVEL, SPECIAL_LEVEL};
	
	static{
		Arrays.sort(ALL);
	}
	
	/**
	 * @return 获取全部枚举
	 */
	public static final StaffLevelEnum[] getAll() {
		return ALL;
	}
	
	/**
	 * 根据code获取枚举
	 * @param code
	 * @return
	 */
	public static final StaffLevelEnum fromStringCode(final String code){
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
	
}
