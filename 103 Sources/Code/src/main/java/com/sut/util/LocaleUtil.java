/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午1:55:43
 * cvs: $Id: $
 */
package com.sut.util;

import java.util.Locale;

/**
 * 线程的本地化环境Locale 通过调用LocaleUtil.getCurrentLocale() 获取当前线程的资源变量
 * @author sut
 * @version $Revision:$
 */
public class LocaleUtil {

	private static final ThreadLocal<Locale> threadLocalVarContext = new ThreadLocal<Locale>(){
		protected synchronized Locale initialValue() {
			return Locale.getDefault();
		}
	};
	
	//默认的线程变量
	private static Locale defaultLocale;
	
	/**
	 * 获取当前线程变量
	 * @param isStaticLocal
	 * @return
	 */
	public static final Locale getCurrentLocale(boolean isStaticLocal){
		if(isStaticLocal){
			if(defaultLocale == null){
				defaultLocale = Locale.SIMPLIFIED_CHINESE;
			}
			return defaultLocale;
		}
		Locale locale = threadLocalVarContext.get();
		if(locale == null){
			locale = Locale.SIMPLIFIED_CHINESE;
			setCurrentLocale(locale, isStaticLocal);
		}
		return locale;
	}
	
	/**
	 * 设置线程的locale
	 * @param locale
	 * @param isStaticLocal
	 */
	public static final void setCurrentLocale(Locale locale, boolean isStaticLocal){
		if(isStaticLocal){
			defaultLocale = locale;
		}else{
			threadLocalVarContext.set(locale);
		}
	}
	
	
}
