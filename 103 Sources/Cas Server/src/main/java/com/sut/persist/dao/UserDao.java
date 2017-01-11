/**
* Copyright (c) 2016 sut
* All rights reserved.
*
* project : cas_server
* created : 2016年10月7日 下午4:15:50
* cvs: $Id: $
*/
package com.sut.persist.dao;

import com.sut.persist.entity.User;

/**
 * 用来查询是否User存在 
 * @author sut
 * @version $Revision:$
 */
public interface UserDao {

	public User getUser(String username);
}
