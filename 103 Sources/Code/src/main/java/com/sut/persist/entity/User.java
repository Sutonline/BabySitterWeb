package com.sut.persist.entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

import com.google.common.base.MoreObjects;
import com.sut.util.meta.SexTypeEnum;
import com.sut.util.meta.WhetherTypeEnum;

/**
 * 用户实体
 * @author sut
 * @Created 2016年9月18日
 */
public class User extends ExtensionalUser implements ExtensionalUserDetails{
	
	/** default Id */
	private static final long serialVersionUID = 1L;
	
	public User(){
	}
	
	/**
	* @param username
	* @param password
	* @param enabled
	* @param accountNonExpired
	* @param credentialsNonExpired
	* @param accountNonLocked
	* @param authorities
	* @param properties
	* @param roles
	* @param permissionMap
	*/
	public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Map<String, Object> properties, Collection<Object> roles, Map<String, List<String>> permissionMap) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, properties, roles, permissionMap);
	}

	private String username;
	private String password;
	private WhetherTypeEnum enable;
	private int    id;
	private java.util.Date createTime;
	private java.util.Date lastLoginDate;
	private SexTypeEnum sex;
	private String email;
	private String mobile;
	private String province;
	private String city;
	private String area;
	private String address;
	private String remark;
	
	protected int hashCode = Integer.MIN_VALUE;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public WhetherTypeEnum getEnable() {
		return enable;
	}

	public void setEnable(WhetherTypeEnum enable) {
		this.enable = enable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(java.util.Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public SexTypeEnum getSex() {
		return sex;
	}

	public void setSex(SexTypeEnum sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return MoreObjects.toStringHelper(User.class)
				.add("username", this.username)
				.add("password", this.password)
				.add("enable", this.enable)
				.toString();
	}
}
