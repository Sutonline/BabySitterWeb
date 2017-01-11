/**
* Copyright (c) 2016 sut
* All rights reserved.
*
* project : BabySitterWeb
* created : 2016年10月8日 下午1:36:42
* cvs: $Id: $
*/
package com.sut.persist.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * 一个经过扩展的用户，包含除Spring security所需User之外的其他扩展信息
 * @author sut
 * @version $Revision:$
 */
public class ExtensionalUser extends User implements ExtensionalUserDetails{
	
	private static final long serialVersionUID = 1L;

	
	private Map<String, Object> properties;
	private Map<String, List<String>> permissionMap;
	private Collection<Object> roles;
	
	/**
	 * default Constructor
	 */
	public ExtensionalUser() {
		super("两个", "ddd", new ArrayList<GrantedAuthority>());
	}
	
	 /**
     * Construct the <code>User</code> with the details required by
     * {@link org.springframework.security.authentication.dao.DaoAuthenticationProvider}.
     *
     * @param username the username presented to the
     *        <code>DaoAuthenticationProvider</code>
     * @param password the password that should be presented to the
     *        <code>DaoAuthenticationProvider</code>
     * @param enabled set to <code>true</code> if the user is enabled
     * @param accountNonExpired set to <code>true</code> if the account has not
     *        expired
     * @param credentialsNonExpired set to <code>true</code> if the credentials
     *        have not expired
     * @param accountNonLocked set to <code>true</code> if the account is not
     *        locked
     * @param authorities the authorities that should be granted to the caller
     *        if they presented the correct username and password and the user
     *        is enabled. Not null.
     * 
     * @param properties 一个包含用户扩展信息的map
     * 
     * @param roles 用户角色
     * 
     * @param permissionMap 用户权限Map
     *
     * @throws IllegalArgumentException if a <code>null</code> value was passed
     *         either as a parameter or as an element in the
     *         <code>GrantedAuthority</code> collection
     */
	public ExtensionalUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, 
			Map<String, Object> properties, Collection<Object> roles, Map<String, List<String>> permissionMap) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.roles = roles;
		this.properties = properties;
		this.permissionMap = permissionMap;
	}

	/**
	* @see com.sut.persist.entity.ExtensionalUserDetails#getProperty(java.lang.String)
	*/
	@Override
	public Object getProperty(String propertyName) {
		if(properties == null)
			return null;
		return properties.get(propertyName);
	}

	/**
	* @see com.sut.persist.entity.ExtensionalUserDetails#addProperty(java.lang.String, java.lang.Object)
	*/
	@Override
	public void addProperty(String key, Object value) {
		if(properties == null)
			properties = new HashMap<String, Object>();
		properties.put(key, value);
	}

	/**
	* @see com.sut.persist.entity.ExtensionalUserDetails#addProperty(java.util.Map)
	*/
	@Override
	public void addProperty(Map<String, Object> map) {
		if(properties == null)
			properties = new HashMap<String, Object>();
		properties.putAll(map);
	}

	/**
	* @see com.sut.persist.entity.ExtensionalUserDetails#setPermissionMap(java.util.Map)
	*/
	@Override
	public void setPermissionMap(Map<String, List<String>> permissionMap) {
		this.permissionMap = permissionMap;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public Collection<Object> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Object> roles) {
		this.roles = roles;
	}

	public Map<String, List<String>> getPermissionMap() {
		return permissionMap;
	}
	
}
