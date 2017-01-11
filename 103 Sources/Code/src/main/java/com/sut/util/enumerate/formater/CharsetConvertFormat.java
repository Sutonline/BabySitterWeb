/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午3:29:20
 * cvs: $Id: $
 */
package com.sut.util.enumerate.formater;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * TODO plz add Comments
 * @author sut
 * @version $Revision:$
 */
public class CharsetConvertFormat implements Formatter, TextFormatter {

	private Charset toCharset;
	private Charset fromCharset;
	
	public CharsetConvertFormat(String fromCharsetName, String toCharsetName) {
		this.toCharset = Charset.forName(toCharsetName);
		this.fromCharset = Charset.forName(fromCharsetName);
	}
	
	/**
	 * 非 Javadoc
	 * @see com.sut.util.enumerate.formater.Formatter#format(java.lang.Object)
	 */
	public String format(Object object) {
		return (object == null) ? null : format(object.toString());
	}
	
	public String format(String string){
		if(string == null)
			return null;
		ByteBuffer r = fromCharset.encode(string);
		CharBuffer a = toCharset.decode(r);
		return a.toString();
	}
	
	/**
	 * (非 Javadoc)
	 * @see com.sut.util.enumerate.formater.Formatter#format(java.lang.Object, java.lang.StringBuffer)
	 */
	public void format(Object object, StringBuffer out) {
		out.append(format(object));
	}
}
