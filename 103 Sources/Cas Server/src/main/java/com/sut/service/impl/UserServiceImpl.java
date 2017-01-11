/**
* Copyright (c) 2016 sut
* All rights reserved.
*
* project : cas_server
* created : 2016年10月7日 下午4:14:40
* cvs: $Id: $
*/
package com.sut.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sut.persist.dao.UserDao;
import com.sut.persist.entity.User;
import com.sut.service.UserService;

/**
 * User service实现
 * @author sut
 * @version $Revision:$
 */
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	/**
	* @see com.sut.service.UserService#login(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean login(String username, String password) {
		logger.info("进行数据库验证!");
		if(username == null || username.equals("") || password == null || password.equals(""))
			return false;
		User user = userDao.getUser(username);
		
		if(user == null || user.getPassword() == null|| ! user.getPassword().equals(password))
			return false;
		
		return true;
	}


	/**********************************************              ***************/
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
