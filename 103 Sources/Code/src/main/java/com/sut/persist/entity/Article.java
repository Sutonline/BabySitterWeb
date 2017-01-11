/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月26日 下午3:33:47
 * cvs: $Id: $
 */
package com.sut.persist.entity;

import com.google.common.base.MoreObjects;
import com.sut.util.meta.ArticleStatusEnum;
import com.sut.util.meta.ArticleTypeEnum;

/**
 * Article entity
 * @author Sut
 * @version $Revision:$
 */
public class Article implements java.io.Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long id;
	private ArticleTypeEnum articleType;
	private String title;
	private String author;
	private java.util.Date timeStamp;
	private java.util.Date publishTime;
	private java.lang.String content;
	private String remark;
	private ArticleStatusEnum articleStatus;
	private String summary;
	private String thumbnail;
	
	/**
	 * 空的构造函数
	 */
	public Article() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArticleTypeEnum getArticleType() {
		return articleType;
	}

	public void setArticleType(ArticleTypeEnum articleType) {
		this.articleType = articleType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public java.util.Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(java.util.Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public java.util.Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(java.util.Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	
	public ArticleStatusEnum getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(ArticleStatusEnum articleStatus) {
		this.articleStatus = articleStatus;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Article.class)
				.add("id", id)
				.add("articleType", articleType)
				.add("author", getAuthor())
				.add("timeStamp", this.timeStamp)
				.add("publishTime", this.publishTime)
				.add("content", getContent() == null ? "" : getContent().length() > 200 ? getContent().substring(0, 200) : getContent())
				.add("remark", remark)
				.add("articleStatus", articleStatus)
				.add("summary", summary)
				.add("thumbnail", thumbnail)
				.toString();
	}
}
