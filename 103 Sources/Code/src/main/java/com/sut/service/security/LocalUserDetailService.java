/**
* Copyright (c) 2016 sut
* All rights reserved.
*
* project : BabySitterWeb
* created : 2016年10月8日 上午11:34:13
* cvs: $Id: $
*/
package com.sut.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sut.persist.dao.BasicUserDao;
import com.sut.persist.entity.BasicUser;
import com.sut.persist.entity.User;


/**
 * 用户详细信息本地实现
 * @author sut
 * @version $Revision:$
 */
public class LocalUserDetailService implements UserDetailsService{
	
	private static final Logger logger = LoggerFactory.getLogger(LocalUserDetailService.class);

	//加入这个类，为了实现国际化
	protected MessageSourceAccessor messageAccessor;
	
	@Autowired
	private BasicUserDao userDao;
	
	
	/**
	* 根据成功验证的用户名获取UserDetail
	* @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("要获取的名字是: " + username);
		BasicUser user = userDao.getUser(username);
		if(user == null)
			return null;
		logger.info(user.toString());
		
		Map<String, List<String>> permissionMap = new HashMap<String, List<String>>();
		//增加authorities, 因为spring本身的checker会检查这个值
		return new User(user.getUsername(), user.getPassword(), true, true, true, true,
				 createAuthorities(), new HashMap<String, Object>(), new ArrayList<Object>(), permissionMap);
	}
	
	private Collection<? extends GrantedAuthority> createAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	/*********************** following are getters and setters *****************/

	public MessageSourceAccessor getMessageAccessor() {
		return messageAccessor;
	}


	public void setMessageAccessor(MessageSourceAccessor messageAccessor) {
		this.messageAccessor = messageAccessor;
	}


	public BasicUserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(BasicUserDao userDao) {
		this.userDao = userDao;
	}

}
