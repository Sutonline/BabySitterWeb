/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月4日 下午10:07:05
 * cvs: $Id: $
 */
package com.sut.util.meta;

import java.util.Arrays;

import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 健康状况
 * @author Sut
 * @version $Revision:$
 */
public class HealthyStatusEnum extends StringEnumTypeImp {
	
private static final long serialVersionUID = 1L;
	
	/**
	 * default Constructor
	 */
	public HealthyStatusEnum(){}
	
	/**
	 * 存储值
	 * @param storeValue
	 */
	public HealthyStatusEnum(String storeValue){
		super(storeValue, HealthyStatusEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	
	/**
	 * 空值
	 */
	public static final HealthyStatusEnum NULL = new HealthyStatusEnum("");
	
	/**
	 * 差
	 */
	public static final HealthyStatusEnum BAD = new HealthyStatusEnum("01");
	
	/**
	 * 中等
	 */
	public static final HealthyStatusEnum MEDIUM = new HealthyStatusEnum("02");
	
	/**
	 * 良好
	 */
	public static final HealthyStatusEnum GOOD = new HealthyStatusEnum("03");
	
	/**
	 * 优秀
	 */
	public static final HealthyStatusEnum PERFECT = new HealthyStatusEnum("04");
	
	/**
	 * 全部枚举
	 */
	public static final HealthyStatusEnum[] ALL = {BAD, MEDIUM, GOOD, PERFECT};
	
	static{
		Arrays.sort(ALL);
	}
	
	/**
	 * @return 获取全部枚举
	 */
	public static final HealthyStatusEnum[] getAll() {
		return ALL;
	}
	
	/**
	 * 根据code获取枚举
	 * @param code
	 * @return
	 */
	public static final HealthyStatusEnum fromStringCode(final String code){
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
}
