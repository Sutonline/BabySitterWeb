/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午2:15:03
 * cvs: $Id: $
 */
package com.sut.util.enumerate.formater;

import com.sut.util.StringUtil;


/**
 * 
 * @author sut
 * @version $Revision:$
 */
public class FormatterHelper {

	public static final Formatter GENERAL_FORMATER = new GeneralFormatter();
	
	public static final CharsetConvertFormat ANSI2GBK = new CharsetConvertFormat(
			StringUtil.ANSI_CHARSET, StringUtil.GBK_CHARSET);
	
	public static final CharsetConvertFormat GBK2ANSI = new CharsetConvertFormat(
			StringUtil.GBK_CHARSET, StringUtil.ANSI_CHARSET);
}
