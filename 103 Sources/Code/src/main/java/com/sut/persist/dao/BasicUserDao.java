package com.sut.persist.dao;

import com.sut.persist.entity.BasicUser;

/**
 * User的dao
 * @author sut
 * @Created 2016年9月18日
 */
public interface BasicUserDao {

	public BasicUser getUser(String name);
	
}
