package com.sut.service;

import org.springframework.stereotype.Service;

import com.sut.persist.entity.BasicUser;

@Service
public interface LoginService {
	
	/**
	 * 登陆
	 * @param username
	 * @param password
	 * @return 返回是否存在
	 */
	public boolean login(String username, String password);
	
	/**
	 * 获取User
	 * @return
	 */
	public BasicUser getUser(String name);
}
