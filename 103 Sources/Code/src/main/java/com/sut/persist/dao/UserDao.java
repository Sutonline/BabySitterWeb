/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月23日 下午5:02:46
 * cvs: $Id: $
 */
package com.sut.persist.dao;

import java.util.List;

import com.sut.persist.entity.User;

/**
 * User Dao
 * @author sut
 * @version $Revision:$
 */
public interface UserDao {

	/**
	 * @param id
	 * @return id对应的user
	 */
	public User getById(int id);
	
	/**
	 * @return 获取全部的User
	 */
	public List<User> getAll();
	
	/**
	 * @param name
	 * @return 根据name获取的user
	 */
	public List<User> getByName(String name);
	
	/**
	 * @param user 插入的user对象
	 */
	public void insert(User user);
	
	/**
	 * 根据id删除user对象
	 * @param id
	 */
	public void deleteById(int id);

	/**
	 * 根据name删除user对象
	 * @param name
	 */
	public void deleteByName(String name);
	
}