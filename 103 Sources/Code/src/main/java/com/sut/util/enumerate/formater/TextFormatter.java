/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午3:29:49
 * cvs: $Id: $
 */
package com.sut.util.enumerate.formater;

/**
 * 文本格式化器 
 * @author sut
 * @version $Revision:$
 */
public interface TextFormatter {
	TextFormatter defaultFormatter = new TextFormatter(){
		public String format(String string){
			return string;
		}
	};
	
	String format(String string);

}
