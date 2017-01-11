/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午2:18:46
 * cvs: $Id: $
 */
package com.sut.util.enumerate.formater;

/**
 * TODO plz add Comments
 * @author sut
 * @version $Revision:$
 */
public class GeneralFormatter implements Formatter {

	GeneralFormatter() {
		super();
	}
	
	/**
	 * 当传入对象为Null的时候返回的值
	 * @return
	 */
	protected String getNullString() {
		return "";
	}
	
	/**
	 * 格式化非空对象的输出
	 * @param object
	 * @return
	 */
	protected String formatString(Object object){
		return String.valueOf(object);
	}
	
	/**
	 * @param object
	 * @param buffer
	 */
	protected void intoStringB(Object object, StringBuffer buffer){
		buffer.append(format(object));
	}
	
	
	/**
	 * (非 Javadoc)
	 * @see com.sut.util.enumerate.formater.Formatter#format(java.lang.Object)
	 */
	@Override
	public String format(Object object) {
		return (object == null) ? getNullString() : formatString(object);
	}

	/**
	 * (非 Javadoc)
	 * @see com.sut.util.enumerate.formater.Formatter#format(java.lang.Object, java.lang.StringBuffer)
	 */
	@Override
	public void format(Object object, StringBuffer out) {
		intoStringB(object, out);
	}
	
	public String toString() {
		return this.getClass().getName();
	}
	
	public int hashCode() {
		return this.getClass().getName().hashCode();
	}

}
