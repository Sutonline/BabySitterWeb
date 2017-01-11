/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 上午11:33:46
 * cvs: $Id: $
 */
package com.sut.util.enumerate.base;

/**
 * 将消息标识字转化为资源文本的接口
 * @author sut
 * @version $Revision:$
 */
public interface MessageResource {
	
	String convert(String string);
	
	/**
	 * 定义了一个没有转换
	 */
	MessageResource noConvert = new MessageResource(){
		public String convert(String string){
			return string;
		}
	};
}
