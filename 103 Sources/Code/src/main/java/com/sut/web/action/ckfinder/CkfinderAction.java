/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月28日 下午2:06:02
 * cvs: $Id: $
 */
package com.sut.web.action.ckfinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sut.web.action.Execution;

/**
 * ckfinder图片浏览和上传action
 * @author Sut
 * @version $Revision:$
 */
@SuppressWarnings("serial")
public class CkfinderAction extends Execution {

	//Type=Images&CKEditor=editor1&CKEditorFuncNum=1&langCode=zh-cn
	private String Type;
	private String CKEditor;
	private String CKEditorFuncNum;
	private String langCode;
	private String configId;
	private String startupPath;
	private String start;
	private String id;
	private String data;
	private String tdata;
	private String func;
	private String thumbFunc;
	private String selectActionFunction;
	
	private static final Logger log = LoggerFactory.getLogger(CkfinderAction.class);
	
	/**
	 * @return 返回ckFinder的主页
	 */
	public String ckfinder() {
		log.debug("进入ckfinder方法");
		return SUCCESS;
	}

	/***************************** Dividing Line ******************************/
	
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getCKEditor() {
		return CKEditor;
	}

	public void setCKEditor(String cKEditor) {
		CKEditor = cKEditor;
	}

	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}

	public void setCKEditorFuncNum(String cKEditorFuncNum) {
		CKEditorFuncNum = cKEditorFuncNum;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public String getStartupPath() {
		return startupPath;
	}

	public void setStartupPath(String startupPath) {
		this.startupPath = startupPath;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTdata() {
		return tdata;
	}

	public void setTdata(String tdata) {
		this.tdata = tdata;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public String getThumbFunc() {
		return thumbFunc;
	}

	public void setThumbFunc(String thumbFunc) {
		this.thumbFunc = thumbFunc;
	}

	public String getSelectActionFunction() {
		return selectActionFunction;
	}

	public void setSelectActionFunction(String selectActionFunction) {
		this.selectActionFunction = selectActionFunction;
	}
	
	
}
