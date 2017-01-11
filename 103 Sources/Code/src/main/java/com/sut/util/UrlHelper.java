/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月7日 下午7:55:32
 * cvs: $Id: $
 */
package com.sut.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * URL encoder
 * @author Sut
 * @version $Revision:$
 */
public class UrlHelper {

	private static Logger LOG = LoggerFactory.getLogger(UrlHelper.class);
	
	public static String UTF8_ENCODE(String s) throws UnsupportedEncodingException {
		String retUrl = URLEncoder.encode(s, "utf-8");
		LOG.debug(retUrl);
		return retUrl;
	}
	
	public static String GBK_ENCODE(String s) throws UnsupportedEncodingException {
		String retUrl = URLEncoder.encode(s, "gbk");
		LOG.debug(retUrl);
		return retUrl;
	}
	
}
