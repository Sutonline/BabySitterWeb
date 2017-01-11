/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年11月4日 下午4:21:30
 * cvs: $Id: $
 */
package com.sut.util.spring;

import java.util.Iterator;
import java.util.List;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;

/**
 * 继承AbstractAutoProxy，实现根据类的名称进行创建代理 
 * @author sut
 * @version $Revision:$
 */
public class BeanTypeAutoProxyCreator extends AbstractAutoProxyCreator implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> beanTypes;
	
	/**
	 * 这里实现是否进行代理
	 * @see org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#getAdvicesAndAdvisorsForBean(java.lang.Class, java.lang.String, org.springframework.aop.TargetSource)
	 */
	@Override
	protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource targetSource) throws BeansException {
		String beanTypeName = beanClass.getName();
		if (this.beanTypes != null) {
			for (Iterator<String> it = this.beanTypes.iterator(); it.hasNext();) {
				String mappedName = (String) it.next();
				if(beanTypeName.equals(mappedName) || isMatch(beanTypeName, mappedName)) {
					return PROXY_WITHOUT_ADDITIONAL_INTERCEPTORS;
				}
			}
		}
		return DO_NOT_PROXY;
	}

	public List<String> getBeanTypes() {
		return beanTypes;
	}

	public void setBeanTypes(List<String> beanTypes) {
		this.beanTypes = beanTypes;
	}
	
	/**
	 * 匹配
	 * @param beanTypeName
	 * @param mappedName
	 * @return
	 */
	private boolean isMatch(String beanTypeName, String mappedName) {
		int idx = mappedName.indexOf("*");
		if (idx >= 0) {
			String pre = mappedName.substring(0, idx);
			String post = mappedName.substring(idx + 1);
			return (beanTypeName.startsWith(pre) && beanTypeName.endsWith(post));
		}
		return false;
	}

}
