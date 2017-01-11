/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午4:19:02
 * cvs: $Id: $
 */
package com.sut.util.meta;

import java.util.Arrays;

import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 教育级别
 * @author Sut
 * @version $Revision:$
 */
public class EducationLevelEnum extends StringEnumTypeImp {

	private static final long serialVersionUID = 1L;
	
	/**
	 * default Constructor
	 */
	public EducationLevelEnum(){}
	
	/**
	 * 存储值
	 * @param storeValue
	 */
	public EducationLevelEnum(String storeValue){
		super(storeValue, EducationLevelEnum.class.getName() + "." + storeValue, SystemEnumUtil.resource);
	}
	
	
	/**
	 * 空值
	 */
	public static final EducationLevelEnum NULL = new EducationLevelEnum("");
	
	/**
	 * 小学
	 */
	public static final EducationLevelEnum PRIMARY_SCHOOL = new EducationLevelEnum("01");
	
	/**
	 * 中学
	 */
	public static final EducationLevelEnum MIDDLE_SCHOOL = new EducationLevelEnum("02");
	
	/**
	 * 高中
	 */
	public static final EducationLevelEnum SENIOR_SCHOOL = new EducationLevelEnum("03");
	
	/**
	 * 大学
	 */
	public static final EducationLevelEnum COLLEDGE_SCHOOL = new EducationLevelEnum("04");
	
	/**
	 * 其他
	 */
	public static final EducationLevelEnum OTHERS = new EducationLevelEnum("05");
	
	/**
	 * 全部枚举
	 */
	public static final EducationLevelEnum[] ALL = {PRIMARY_SCHOOL, 
		MIDDLE_SCHOOL, SENIOR_SCHOOL, COLLEDGE_SCHOOL, OTHERS};
	
	static{
		Arrays.sort(ALL);
	}
	
	/**
	 * @return 获取全部枚举
	 */
	public static final EducationLevelEnum[] getAll() {
		return ALL;
	}
	
	/**
	 * 根据code获取枚举
	 * @param code
	 * @return
	 */
	public static final EducationLevelEnum fromStringCode(final String code){
		int pos = search(ALL, code);
		return (pos >= 0) ? ALL[pos] : null;
	}
	
}
