/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年12月30日 下午3:53:29
 * cvs: $Id: $
 */
package com.sut.test;

/**
 * return test 
 * @author Sut
 * @version $Revision:$
 */
public class ReturnTest {

	/**
	 * 在catch中要么return要么向上抛
	 * @return
	 */
	public static String test() {
		try {
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	public static void main(String[] args) {
		
	}
	
}
