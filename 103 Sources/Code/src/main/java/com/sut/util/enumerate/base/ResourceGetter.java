/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午1:49:56
 * cvs: $Id: $
 */
package com.sut.util.enumerate.base;

import java.util.ResourceBundle;

import com.sut.util.LocaleUtil;
import com.sut.util.enumerate.formater.CharsetConvertFormat;
import com.sut.util.enumerate.formater.FormatterHelper;

/**
 * MessageResource的支持类 
 * @author sut
 * @version $Revision:$
 */
public class ResourceGetter implements MessageResource {

	/* 默认包内的资源名称 */
	static final String DEFAULT_RESOURCE_NAME = "Resource";
	
	public static final boolean NOT_USE_ANSIUNICODE_TEXTSOURCE = false;
	
	public static final boolean USE_ANSIUNICODE_TEXTSOURCE = true;
	
	public static final boolean USE_ISO8859_1_CHARSET = true;
	
	public static final boolean NOT_USE_ISO8859_1_CHARSET = false;
	
	final ClassLoader bundleClassLoader;
	
	final String rn;
	
	public ResourceGetter(String resourceName, ClassLoader classLoader){
		this.rn = resourceName;
		this.bundleClassLoader = classLoader;
	}
	
	private ResourceBundle getBundle() {
		return ResourceBundle.getBundle(rn, LocaleUtil.getCurrentLocale(true), getClassLoader());
	}
	
	
	private ClassLoader getClassLoader(){
		return this.bundleClassLoader;
	}
	
	/**
	 * 获取该类所在Package下的命名为Resource的资源对象，默认用staticLocal
	 * @param clazz 相关类
	 * @param resourceIsAnsiAsciiMode
	 * @return 获取相关类所在包的默认资源对象
	 */
	@SuppressWarnings("rawtypes")
	public static final MessageResource getDefaultClassResource(Class clazz,
										boolean resourceIsAnsiAsciiMode) {
		return ResourceGetter.getMessageResource((clazz.getPackage().getName() + "." + DEFAULT_RESOURCE_NAME)
				, clazz.getClassLoader(),  resourceIsAnsiAsciiMode, true);
	}
	
	
	public static MessageResource getMessageResource(String resourceName,
				ClassLoader classLoader, boolean resourceIsAnsiAsciiMode, 
				boolean isStaticLocal) {
		return isStaticLocal ? getStaticMessageResource(resourceName, classLoader, 
				resourceIsAnsiAsciiMode, isStaticLocal) :
					getLocaleMessageResource(resourceName, classLoader, 
							resourceIsAnsiAsciiMode, isStaticLocal);
	}
	
	public static final MessageResource getStaticMessageResource(String resourceName,
			ClassLoader classLoader, boolean resourceIsAnsiAsciiMode, boolean useISO8859_1CHARSET){
		return wrapCharsetSetting(resourceIsAnsiAsciiMode, new StaticResourceGetter(resourceName, classLoader), 
				useISO8859_1CHARSET);
	}
	
	public static final MessageResource getLocaleMessageResource(String resourceName, 
			ClassLoader classLoader, boolean resourceIsAnsiAsciiMode, 
			boolean useISO8859_1CHARSET) {
		return wrapCharsetSetting(resourceIsAnsiAsciiMode, new ResourceGetter(resourceName, classLoader), useISO8859_1CHARSET);
	}
	
	
	private static final MessageResource wrapCharsetSetting(
			boolean resourceSourceIsAsciiUnicodeMode,
			MessageResource innerResource, boolean useISO8859_1CHARSET){
		if(useISO8859_1CHARSET && (resourceSourceIsAsciiUnicodeMode == USE_ANSIUNICODE_TEXTSOURCE)) {
			return new CharsetConvertResource(innerResource, FormatterHelper.GBK2ANSI);
		}else if(!useISO8859_1CHARSET && (resourceSourceIsAsciiUnicodeMode != USE_ANSIUNICODE_TEXTSOURCE)) {
			return new CharsetConvertResource(innerResource, FormatterHelper.ANSI2GBK);
		}else
			return innerResource;
	}
	
	
	
	/**
	 * 静态内部类
	 */
	private static final class CharsetConvertResource implements MessageResource {
		private final MessageResource resource;
		private final CharsetConvertFormat  convertFormat;
		
		private CharsetConvertResource(MessageResource resource, CharsetConvertFormat format){
			super();
			this.resource = resource;
			this.convertFormat = format;
		}
		
		public String convert(String string) {
			String s = resource.convert(string);
			return convertFormat.format(s);
		}
	}
	
	/**
	 * 静态内部类
	 */
	private static class StaticResourceGetter extends ResourceGetter {
		private ResourceBundle bundle; //Done将bundle迟装载
		
		private StaticResourceGetter(String resourceName, ClassLoader classLoader) {
			super(resourceName, classLoader);
		}
		
		@SuppressWarnings("unused")
		public ResourceBundle getBundle() {
			if(bundle == null)
				bundle = ResourceBundle.getBundle(this.rn, LocaleUtil.getCurrentLocale(true), 
							this.bundleClassLoader);
			return bundle;
		}
	}
	
	/**
	 * @see com.sut.util.enumerate.base.MessageResource#convert(java.lang.String)
	 */
	@Override
	public String convert(String string) {
		return getBundle().getString(string);
	}
	


}
