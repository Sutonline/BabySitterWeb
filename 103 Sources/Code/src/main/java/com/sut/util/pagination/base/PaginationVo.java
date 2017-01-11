/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月29日 下午5:11:18
 * cvs: $Id: $
 */
package com.sut.util.pagination.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

/**
 * pageInation的实现类(剩下的可以从request中去，比如页号之类的参数.) TODO 需要结合mybatis + mysql 的分页方式
 * 
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("rawtypes")
public class PaginationVo implements PaginatedList {

	private List list; // 数据集
	private int pageNumber = 1; // 页号
	private int objectsPerPage = 15; // 每页显示的记录数
	private int fullListSize = 0; // 全部记录数
	private String sortCriterion;
	private SortOrderEnum sortDirection;
	private String searchId;
   
	
	/**
	 * 默认的构造函数
	 */
	public PaginationVo() {
		super();
	}
	
	/**
	 * 构造一个页面
	 * @param pageNumber
	 * @param fullListSize
	 * @param objectsPerPage
	 */
	public PaginationVo(int pageNumber, int fullListSize, int objectsPerPage) {
		this.pageNumber = pageNumber;
		this.fullListSize = fullListSize;
		this.objectsPerPage = objectsPerPage;
	}
	
	/**
	 * @see org.displaytag.pagination.PaginatedList#getList()
	 */
	@Override
	public List getList() {
		return this.list;
	}

	/**
	 * @see org.displaytag.pagination.PaginatedList#getPageNumber()
	 */
	@Override
	public int getPageNumber() {
		return this.pageNumber;
	}

	/**
	 * @see org.displaytag.pagination.PaginatedList#getObjectsPerPage()
	 */
	@Override
	public int getObjectsPerPage() {
		return this.objectsPerPage;
	}

	/**
	 * @see org.displaytag.pagination.PaginatedList#getFullListSize()
	 */
	@Override
	public int getFullListSize() {
		return this.fullListSize;
	}

	/**
	 * @see org.displaytag.pagination.PaginatedList#getSortCriterion()
	 */
	@Override
	public String getSortCriterion() {
		return this.sortCriterion;
	}

	/**
	 * @see org.displaytag.pagination.PaginatedList#getSortDirection()
	 */
	@Override
	public SortOrderEnum getSortDirection() {
		return this.sortDirection;
	}

	/**
	 * @see org.displaytag.pagination.PaginatedList#getSearchId()
	 */
	@Override
	public String getSearchId() {
		return this.searchId;
	}

	/**
	 * 根据总的数据集和每页需要的首记录、尾记录索引，从总记录集中得到需要的记录集
	 * 这是一个取巧的分页方法，并非真正的根据每页请求拼接sql进行查询，而是对于真个 数据查询的结果从中取各页需要的数据集合，
	 * 对于超大数据量的查询效率可能不会太高
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void getCurrentPageRecord() {
		ArrayList v = new ArrayList();
		Iterator iterator = null;
		try {
			if (this.getList() != null) {
				iterator = this.getList().iterator();
				int i = 0;
				int fromRow = 0;
				int toRow = 0;
				if (this.getPageNumber() == 1) { // 首页
					fromRow = 1; // 从第一行开始
					toRow = this.getObjectsPerPage();
				} else {
					fromRow = (this.getPageNumber() - 1) * this.getObjectsPerPage() + 1;
					toRow = fromRow + this.getObjectsPerPage();
				}
				if (toRow > this.getFullListSize()) // 超过总的记录数
					toRow = this.getFullListSize();
				while (iterator.hasNext()) {
					i++;
					if (i < fromRow) {
						iterator.next();
						continue;
					} else if (i > toRow) {
						iterator.next();
						continue;
					} else {
						v.add(iterator.next());
					}
				}
				this.setList(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/****************************** Dividing Line *****************************/

	public void setList(List list) {
		this.list = list;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = objectsPerPage;
	}

	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
	}

	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public void setSortDirection(SortOrderEnum sortDirection) {
		this.sortDirection = sortDirection;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

}
