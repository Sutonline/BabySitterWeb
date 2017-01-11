/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月10日 下午2:16:27
 * cvs: $Id: $
 */
package com.sut.persist.dao;

import java.util.List;

import com.sut.persist.entity.StaffReview;
import com.sut.util.meta.ArticleStatusEnum;

/**
 * 员工评论Dao
 * @author Sut
 * @version $Revision:$
 */
public interface StaffReviewDao {

	/**
	 * @return 返回一个staffReview
	 */
	public StaffReview getById();
	
	/**
	 * @return 获取所有评论
	 */
	public List<StaffReview> getAll();
	
	
	/**
	 * @return 获取一个用户的所有评论
	 */
	public List<StaffReview> getByUser(long staffId);
	
	
	/**
	 * @param reivewStatus
	 * @return 根据评论的审核状态得到所有staffReview
	 */
	public List<StaffReview> getByStatus(ArticleStatusEnum reivewStatus);
	
	/**
	 * 更新评论状态
	 * @param reviewStatus
	 */
	public void updateStatus(ArticleStatusEnum reviewStatus, long id);
	
	/**
	 * 删除所有重复ip的待审核的评论
	 * @param ipAddress
	 */
	public void deleteByIpAddress(String ipAddress);
	
	/**
	 * 根据id删除
	 * @param id
	 */
	public void deleteById(long id);
	
	
	/**
	 * 根据状态去删除
	 * @param reviewStatus
	 */
	public void deleteAll(ArticleStatusEnum reviewStatus);
	
	/**
	 * 删除某个员工的评论
	 * @param staffId
	 */
	public void deleteByStaff(long staffId);
}
