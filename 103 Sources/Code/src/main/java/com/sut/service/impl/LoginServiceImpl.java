package com.sut.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sut.persist.dao.UserDao;
import com.sut.persist.entity.BasicUser;
import com.sut.persist.entity.User;
import com.sut.service.LoginService;
import com.sut.util.ListUtilHelper;
import com.sut.util.StringUtil;
import com.sut.util.meta.WhetherTypeEnum;

@Component
public class LoginServiceImpl implements LoginService{
	
	private UserDao userDao;

	/**
	 * @see com.sut.service.LoginService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String username, String password) {
		List<User> list = userDao.getByName(username);
		if (ListUtilHelper.isNullOrEmpty(list))
			return false;
		User user = list.get(0);
		
		if (StringUtil.isNullorEmpty(user.getPassword()) || StringUtil.isNullorEmpty(password))
			return false;
		
		if (user.getPassword().equals(password) && user.getEnable() != null && user.getEnable() == WhetherTypeEnum.YES) 
			return true;
		
		return false;
	}

	/** 
	 * @see com.sut.service.LoginService#getUser()
	 */
	@Override
	public BasicUser getUser(String name) {
		return null;
	}

	/********************************* Dividing Line *****************************/
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
