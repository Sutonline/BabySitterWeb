/**
* Copyright (c) 2016 sut
* All rights reserved.
*
* project : cas_server
* created : 2016年10月7日 下午4:11:59
* cvs: $Id: $
*/
package com.sut.service;

/**
 * User service用来验证user 
 * @author sut
 * @version $Revision:$
 */
public interface UserService {

	/** login */
	public boolean login(String username, String password);
}
