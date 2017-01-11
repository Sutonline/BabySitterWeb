/**
* Copyright (c) 2016 sut
* All rights reserved.
*
* project : cas_server
* created : 2016年10月7日 下午4:16:26
* cvs: $Id: $
*/
package com.sut.persist.entity;

import java.io.Serializable;

/**
 * User实体 
 * @author sut
 * @version $Revision:$
 */
public class User implements Serializable{
	
	/**
	* default SerialId
	*/
	private static final long serialVersionUID = 1L;
	
	
	private String username;
	private String password;
	private String enable;
	
	public User(){
		super();
	}
	
	/**
	* @param username
	* @param password
	*/
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
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
