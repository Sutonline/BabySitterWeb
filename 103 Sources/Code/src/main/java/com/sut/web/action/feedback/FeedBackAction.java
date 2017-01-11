package com.sut.web.action.feedback;

import com.sut.web.action.Execution;

/**
 * feedback action
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("serial")
public class FeedBackAction extends Execution {
	
	/**
	 * @return 返回评论的列表页面
	 */
	public String listAll() {
		return SUCCESS;
	}
	
	/**
	 * @return 评论编辑页面
	 */
	public String reply() {
		return SUCCESS;
	}
	
	
	
}
