/**
* Copyright (c) 2016 sut
* All rights reserved.
*
* project : cas_server
* created : 2016年10月7日 下午4:08:21
* cvs: $Id: $
*/
package com.sut.cas.authentication.security.providers;

import java.security.GeneralSecurityException;

import javax.security.auth.login.FailedLoginException;

import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;

import com.sut.service.UserService;

/**
 * 使用数据库验证
 * @author sut
 * @version $Revision:$
 */
public class SimpleUsernamePasswordAuthentication extends AbstractUsernamePasswordAuthenticationHandler{

	private UserService userService;
	
	/**
	* @see org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler#authenticateUsernamePasswordInternal(org.jasig.cas.authentication.UsernamePasswordCredential)
	*/
	@Override
	protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential transformedCredential) throws GeneralSecurityException, PreventedException {
		if(transformedCredential == null)
			throw new FailedLoginException("No user can be accepted because none is defined");
		final String username = transformedCredential.getUsername();
		final String encodedPassword = this.getPasswordEncoder().encode(transformedCredential.getPassword());
		
		return doAuthenticate(transformedCredential, username, encodedPassword);
	}
	
	
	/**
	* @param credential
	* @param username
	* @param encodedPassword
	* @return
	 * @throws FailedLoginException 
	*/
	private HandlerResult doAuthenticate(UsernamePasswordCredential credential, String username, String encodedPassword) throws FailedLoginException{
		if(! userService.login(username, encodedPassword))
			throw new FailedLoginException("用户名或密码错误!");
		return createHandlerResult(credential, this.principalFactory.createPrincipal(username), null);
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
