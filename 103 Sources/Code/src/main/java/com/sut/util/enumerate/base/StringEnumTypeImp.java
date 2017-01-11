/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 上午11:29:41
 * cvs: $Id: $
 */
package com.sut.util.enumerate.base;

import java.io.Serializable;

/**
 * 这是String类型的Enum基类<br/>
 * 从String转向Enum的时候，需要
 * @author sut
 * @version $Revision:$
 */
public abstract class StringEnumTypeImp implements java.io.Serializable, Comparable<StringEnumTypeImp> {

	/**
	 * generate serialVersionUID
	 */
	private static final long serialVersionUID = 5249554502744912199L;

	private transient String resourceKey;
	private Serializable keyValue;
	
	private transient final MessageResource getter;
	
	protected StringEnumTypeImp(){
		this("", "", null);
	};
	
	protected StringEnumTypeImp(String storeValue, String resourceKey, MessageResource messageResource){
		this.resourceKey = resourceKey;
		this.keyValue = storeValue;
		getter = messageResource == null ? MessageResource.noConvert : messageResource;
	}
	
	/**
	 * 根据resourceKey获取displayText
	 * @return
	 */
	public String getDisplayText(){
		return getter.convert(this.resourceKey);
	}
	
	
	/**
	 * 提供一个类似displayText的值
	 * @return
	 */
	public String getStringValue(){
		return getStoreValue();
	}
	
	/**
	 * 获取传入的storeValue
	 * @return
	 */
	public String getStoreValue(){
		return (String) this.keyValue;
	}
	
	public String getResourceKey(){
		return this.resourceKey;
	}

	public int compareTo(StringEnumTypeImp stringEnum) {
		if (stringEnum != null)
			return this.getStoreValue().compareTo(stringEnum.getStoreValue());
		else
			return -1;
	}
	
	public static final int search(StringEnumTypeImp[] se, String keyCode){
		if(keyCode == null)
			return -1;
		int low = 0;
		int high = se.length - 1;
		
		while(low <= high){
			int mid = (low + high) >> 1;
			Comparable<String> midVal = (Comparable<String>) se[mid].getStoreValue();
			int cmp = midVal.compareTo(keyCode);
			
			if(cmp < 0)
				low = mid + 1;
			else if (cmp > 0)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); //key not found.
	}
	
}
