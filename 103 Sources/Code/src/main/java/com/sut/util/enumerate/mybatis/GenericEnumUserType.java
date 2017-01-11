/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午4:23:14
 * cvs: $Id: $
 */
package com.sut.util.enumerate.mybatis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.sut.util.enumerate.base.StringEnumTypeImp;

/**
 * 用来处理我们自定义的枚举 
 * @author sut
 * @version $Revision:$
 */
public class GenericEnumUserType<E extends StringEnumTypeImp> extends BaseTypeHandler<E>{
	
	private static final Logger LOG = LoggerFactory.getLogger(GenericEnumUserType.class);
	
	//mybatis will pass actual class when constructing TypeHandler
	private Class<E> type;
	
	private static final String fromStringCode = "fromStringCode";
	
	public GenericEnumUserType(Class<E> type){
		Preconditions.checkNotNull(type, "Type argument cannot be null");
		this.type = type;
	}

	/**
	 * 设置非空参数
	 * @see org.apache.ibatis.type.BaseTypeHandler#setNonNullParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, StringEnumTypeImp parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, parameter.getStoreValue());
	}

	/**
	 * 得到非空结果，然后转换成E<br>
	 * 利用反射调用静态的方法<br>
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.ResultSet, java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
		LOG.info("获取到的类型是{}", type);
		String storeValue =  rs.getString(columnName);
		Preconditions.checkNotNull(type, "Type argument cannot be null");
		try {
			Method fromMethod = type.getMethod(fromStringCode, String.class);
			return (E) fromMethod.invoke(null, storeValue);
		} catch (IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 这个是按照column index进行获取的时候
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.ResultSet, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		LOG.info("获取到的类型是{}", type);
		String storeValue =  rs.getString(columnIndex);
		Preconditions.checkNotNull(type, "Type argument cannot be null");
		try {
			Method fromMethod = type.getMethod(fromStringCode, String.class);
			return (E) fromMethod.invoke(null, storeValue);
		} catch (IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 针对存储过程的设置
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.CallableStatement, int)
	 */
	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
