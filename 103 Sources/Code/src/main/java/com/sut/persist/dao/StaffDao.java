/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月4日 下午10:12:55
 * cvs: $Id: $
 */
package com.sut.persist.dao;

import java.util.List;

import com.sut.persist.entity.Staff;
import com.sut.util.meta.ServiceTypeEnum;

/**
 * 职工dao
 * @author Sut
 * @version $Revision:$
 */
public interface StaffDao {

	/**
	 * @param id
	 * @return 返回id对应的staff
	 */
	public Staff getById(long id);
	
	/**
	 * @param serviceType
	 * @return 返回服务类型的staff集合
	 */
	public List<Staff> getByCategory(ServiceTypeEnum serviceType);
	
	/**
	 * @return 返回所有的职工集合
	 */
	public List<Staff> getAll();
	
	/**
	 * 保存staff
	 * @param staff
	 */
	public void insert(Staff staff);
	
	/**
	 * 根据id更新staff信息
	 * @param staff
	 * @param id
	 */
	public void update(Staff staff, long id);
	
	/**
	 * 根据id删除staff
	 * @param id
	 */
	public void deleteById(long id);
	
	/**
	 * 删除某个服务类型的所有职工
	 * @param serviceType
	 */
	public void deleteByCategory(ServiceTypeEnum serviceType);
}
