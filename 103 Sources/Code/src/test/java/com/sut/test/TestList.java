/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月1日 下午2:03:54
 * cvs: $Id: $
 */
package com.sut.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.sut.persist.entity.Article;
import com.sut.util.UrlHelper;

/**
 * TestList
 * @author Sut
 * @version $Revision:$
 */
public class TestList {

	private ArrayList<Article> list;
	
	public TestList() {}
	
	public TestList(int size) {
		
		for (int i = 0; i < size; i++){
			Article article = new Article();
			article.setContent("xxxx");
			list.add(article);
		}
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(UrlHelper.GBK_ENCODE("功能地图"));
	}
	
}
