/**
* Copyright (c) 2016 sut
* All rights reserved.
*
* project : BabySitterWeb
* created : 2016年10月8日 下午1:37:32
* cvs: $Id: $
*/
package com.sut.persist.entity;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 对{@link UserDetails}做了扩展。可以通过{@link #getProperty(String)}得到额外的用户扩展信息
 * @author sut
 * @version $Revision:$
 */
public interface ExtensionalUserDetails extends UserDetails{
	
	/**
	 * 得到用户扩展属性
	* @param propertyName
	* @return 扩展用户属性
	*/
	public Object getProperty(String propertyName);
	
	/**
	 * 添加用户扩展属性
	* @param key
	* @param value
	* @return
	*/
	public void addProperty(String key, Object value);
	
	/**
	 * 添加用户扩展属性
	* @param map
	*/
	public void addProperty(Map<String, Object> map);
	
	/**
	 * 添加权限
	* @param permissionMap
	*/
	public void setPermissionMap(Map<String, List<String>> permissionMap);
	
}
