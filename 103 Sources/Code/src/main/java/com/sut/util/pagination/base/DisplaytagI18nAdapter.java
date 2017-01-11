/**
 * Copyright (c) 2017 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2017年1月3日 下午1:41:15
 * cvs: $Id: $
 */
package com.sut.util.pagination.base;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.jstl.core.Config;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.tag.common.fmt.BundleSupport;
import org.displaytag.Messages;
import org.displaytag.localization.I18nResourceProvider;
import org.displaytag.localization.LocaleResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义国际化支持(unused)
 * @author Sut
 * @version $Revision:$
 */
public class DisplaytagI18nAdapter implements I18nResourceProvider, LocaleResolver {

	/**
     * prefix/suffix for missing entries.
     */
    public static final String UNDEFINED_KEY = "???"; //$NON-NLS-1$

    /**
     * logger.
     */
    private static Logger LOG = LoggerFactory.getLogger(DisplaytagI18nAdapter.class);

    /**
     * Instantiates a new I18nJstlAdapter. Throw a NoClassDefFound error if BundleSupport is not available.
     */
    public DisplaytagI18nAdapter()
    {
        // this will check if BundleSupport is available
        // if a NoClassDefFound error is thrown, the DisplaytagI18nAdapter will not be used
        BundleSupport.class.hashCode();
    }

    /**
     * 获取locale
     * @see LocaleResolver#resolveLocale(HttpServletRequest)
     */
    public Locale resolveLocale(HttpServletRequest request)
    {
        Locale locale = (Locale) Config.get(request.getSession(), Config.FMT_LOCALE);
        if (locale == null)
        {
            locale = request.getLocale();
        }
        return locale;
    }

    /**
     * get key对应的message
     * @see I18nResourceProvider#getResource(String, String, Tag, PageContext)
     */
    public String getResource(String resourceKey, String defaultValue, Tag tag, PageContext pageContext)
    {

        // if titleKey isn't defined either, use property
        String key = (resourceKey != null) ? resourceKey : defaultValue;
        String title = null;
        ResourceBundle bundle = null;

        // jakarta jstl implementation, there is no other way to get the bundle from the parent fmt:bundle tag
        Tag bundleTag = TagSupport.findAncestorWithClass(tag, BundleSupport.class);
        if (bundleTag != null)
        {
            BundleSupport parent = (BundleSupport) bundleTag;
            if (key != null)
            {
                String prefix = parent.getPrefix();
                if (prefix != null)
                {
                    key = prefix + key;
                }
            }
            bundle = parent.getLocalizationContext().getResourceBundle();
        }

        // resin jstl implementation, more versatile (we don't need to look up resin classes)
        if (bundle == null)
        {
            Object cauchoBundle = pageContext.getAttribute("caucho.bundle"); //$NON-NLS-1$
            if (cauchoBundle != null && cauchoBundle instanceof LocalizationContext)
            {
                bundle = ((LocalizationContext) cauchoBundle).getResourceBundle();

                // handle prefix just like resin does
                String prefix = (String) pageContext.getAttribute("caucho.bundle.prefix"); //$NON-NLS-1$
                if (prefix != null)
                {
                    key = prefix + key;
                }
            }
        }

        // standard jstl localizationContest
        if (bundle == null)
        {
            // check for the localizationContext in applicationScope, set in web.xml
            LocalizationContext localization = BundleSupport.getLocalizationContext(pageContext);

            if (localization != null)
            {
                bundle = localization.getResourceBundle();
            }
        }

        if (bundle != null)
        {
            try
            {
                title = bundle.getString(key);
            }
            catch (MissingResourceException e)
            {
                LOG.debug(Messages.getString("Localization.missingkey", key)); //$NON-NLS-1$

                // if user explicitely added a titleKey we guess this is an error
                if (resourceKey != null)
                {
                    title = UNDEFINED_KEY + resourceKey + UNDEFINED_KEY;
                }
            }
        }

        return title;
    }

}
