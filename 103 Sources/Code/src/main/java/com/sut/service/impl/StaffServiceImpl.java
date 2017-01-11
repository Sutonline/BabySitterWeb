/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月5日 上午9:17:10
 * cvs: $Id: $
 */
package com.sut.service.impl;

import java.util.List;

import com.sut.persist.dao.StaffDao;
import com.sut.persist.dao.StaffReviewDao;
import com.sut.persist.entity.Staff;
import com.sut.service.StaffService;
import com.sut.util.meta.ServiceTypeEnum;

/**
 * 员工实现类
 * @author Sut
 * @version $Revision:$
 */
public class StaffServiceImpl implements StaffService {

	private StaffDao staffDao;
	private StaffReviewDao staffReviewDao;
	
	/**
	 * @see com.sut.service.StaffService#getById(long)
	 */
	@Override
	public Staff getById(long id) {
		return staffDao.getById(id);
	}

	/**
	 * @see com.sut.service.StaffService#save(com.sut.persist.entity.Staff)
	 */
	@Override
	public void save(Staff staff) {
		staffDao.insert(staff);
	}

	/**
	 * @see com.sut.service.StaffService#update(com.sut.persist.entity.Staff)
	 */
	@Override
	public void update(Staff staff) {
		staffDao.update(staff, staff.getId());
	}

	/**
	 * @see com.sut.service.StaffService#deleteById(long)
	 */
	@Override
	public void deleteById(long id) {
		staffDao.deleteById(id);
	}

	/**
	 * @see com.sut.service.StaffService#getByCategory(com.sut.util.meta.ServiceTypeEnum)
	 */
	@Override
	public List<Staff> getByCategory(ServiceTypeEnum serviceType) {
		return staffDao.getByCategory(serviceType);
	}

	/**
	 * @see com.sut.service.StaffService#deleteByCategory(com.sut.util.meta.ServiceTypeEnum)
	 */
	@Override
	public void deleteByCategory(ServiceTypeEnum serviceType) {
		staffDao.deleteByCategory(serviceType);
	}

	/************************************ Dividing Line ************************/
	
	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	public StaffReviewDao getStaffReviewDao() {
		return staffReviewDao;
	}

	public void setStaffReviewDao(StaffReviewDao staffReviewDao) {
		this.staffReviewDao = staffReviewDao;
	}

}
