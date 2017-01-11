/**
* Copyright (c) 2016 sut
* All rights reserved.
*
* project : BabySitterWeb
* created : 2016年10月8日 下午3:23:33
* cvs: $Id: $
*/
package com.sut.service.security.web.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.sut.persist.entity.ExtensionalUserDetails;

/**
 * 从CAS验证成功后处理
 * @author sut
 * @version $Revision:$
 */
public class SimpleRequestAuthenticationSuccessHandler extends SimpleRequestAwareAuthenticationSuccess{

	private static final Logger logger = LoggerFactory.getLogger(SimpleRequestAuthenticationSuccessHandler.class);
	
	//protected IUserPermissionManager userPermissionManager;
	
	public SimpleRequestAuthenticationSuccessHandler(){
	}
	
	public SimpleRequestAuthenticationSuccessHandler(String defaultTargetUrl){
		setDefaultTargetUrl(defaultTargetUrl);
	}
	
	public void onAuthenticatioinSuccess(HttpServletRequest request, HttpServletResponse response,
			 Authentication authentication) throws IOException, ServletException{
		if(authentication instanceof CasAuthenticationToken){
			CasAuthenticationToken casauthentication = (CasAuthenticationToken) authentication;
			Assertion assertion = casauthentication.getAssertion();
			AttributePrincipal principal = assertion.getPrincipal();
			if(casauthentication.getUserDetails() instanceof ExtensionalUserDetails){
				ExtensionalUserDetails user = (ExtensionalUserDetails) casauthentication.getUserDetails();
				user.addProperty(principal.getAttributes());
				if(((String) user.getProperty("permissions")) != null){ //TODO StringUtils.isNotBlank
					//user.setPermissionMap(userPerss);
				}else{
					user.setPermissionMap(null);
				}
			}
			if(logger.isDebugEnabled()){
				logger.debug("Authentication Success and Return User Attribute is:" + principal.getAttributes());
			}
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
