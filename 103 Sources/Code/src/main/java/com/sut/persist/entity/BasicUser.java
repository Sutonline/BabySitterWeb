/**
* Copyright (c) 2016 sut
* All rights reserved.
*
* project : BabySitterWeb
* created : 2016年10月8日 下午3:06:13
* cvs: $Id: $
*/
package com.sut.persist.entity;

/**
 * 配合从数据库获取的信息 
 * @author sut
 * @version $Revision:$
 */
public class BasicUser implements java.io.Serializable{

	/**
	* generate serialUID
	*/
	private static final long serialVersionUID = 8940433753818410851L;
	
	private String username;
	private String password;
	private String enable;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
}
