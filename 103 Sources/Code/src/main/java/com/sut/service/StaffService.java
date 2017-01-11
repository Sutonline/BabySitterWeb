/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月5日 上午9:11:18
 * cvs: $Id: $
 */
package com.sut.service;

import java.util.List;

import com.sut.persist.entity.Staff;
import com.sut.util.meta.ServiceTypeEnum;

/**
 * 员工service接口
 * @author Sut
 * @version $Revision:$
 */
public interface StaffService {

	/**
	 * @param id
	 * @return 根据id获取对应的staff
	 */
	public Staff getById(long id);
	
	/**
	 * 保存staff
	 * @param staff
	 */
	public void save(Staff staff);
	
	/**
	 * 更新staff
	 * @param staff
	 */
	public void update(Staff staff);
	
	/**
	 * 根据id进行删除
	 * @param id
	 */
	public void deleteById(long id);
	
	/**
	 * @param serviceType
	 * @return list&ltStaff&gt
	 */
	public List<Staff> getByCategory(ServiceTypeEnum serviceType);
	
	/**
	 * 根据serviceType进行删除
	 * @param serviceType
	 */
	public void deleteByCategory(ServiceTypeEnum serviceType);
}
