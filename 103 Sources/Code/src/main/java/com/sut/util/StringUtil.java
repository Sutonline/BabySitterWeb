/**
 * Copyright (c) 2016 sut
 * All rights reserved.
 *
 * project : BabySitterWeb
 * created : 2016年10月21日 下午2:25:42
 * cvs: $Id: $
 */
package com.sut.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.StringTokenizer;

/**
 * 字符串工具类
 * @author sut
 * @version $Revision:$
 */
public class StringUtil {
	
	private StringUtil(){
	}

	public static final String htmlEncode(Object obj) {
		if(obj == null)
			return "";
		String str = String.valueOf(obj);
		int k = str.length();
		if(k == 0)
			return "";
		StringBuffer buf = new StringBuffer(Math.round(k * 1.1f));
		int p = 0;
		for(int i = 0; i < k; i++){
			switch(str.charAt(i)){
			case '"' : {
				if(p < i){
					buf.append(str.substring(p, i));
				}
				buf.append("&quot;");
				p = i + 1;
				break;
			}
			case '<' : {
				if(p < i){
					buf.append(str.substring(p, i));
				}
				buf.append("&lt;");
				p = i + 1;
				break;
			}
			case '>' : {
				if(p < i){
					buf.append(str.substring(p, i));
				}
				buf.append("&gt;");
				p = i + 1;
				break;
			}
			case '&' : {
				if(p < i) {
					buf.append(str.substring(p, i));
				}
				buf.append("&amp");
				p = i + 1;
				break;
			}
			case '\'' : {
				if(p < i){
					buf.append(str.substring(p, i));
				}
				buf.append("&apos;");
				p = i + 1;
				break;
			}
		  }
		}
		if(p < k){
			buf.append(str.substring(p));
		}
		return buf.toString();
	}
	
	public static String LTrim(String r) {
		if(r == null)
			return null;
		int len = r.length();
		
		if(len > 0 && r.charAt(0) <= ' '){
			int i = 1;
			while(i < len && r.charAt(i) <= ' '){
				i++;
			}
			r = r.substring(i, len);
		}
		return r;
	}
	
	public static String emptyToNull(String noNullString) {
		if(noNullString.length() > 0){
			for(int i = 0, l = noNullString.length(); i < l; i++){
				if(noNullString.charAt(i) != ' ')
					return noNullString;
			}
		}
		return null;
	}
	
	/**
	 * 原来的空值转换为空白
	 * @param string
	 * @return
	 */
	public static String safeNotNull(String string) {
		return (string != null) ? string : "";
	}
	
	/**
	 * 去除右边的空格
	 * @param s
	 * @return
	 */
	public static String RTrim(String s) {
		if(s == null)
			return null;
		int i = s.length() - 1;
		
		if(i >= 0 && s.charAt(i) <= ' '){
			i--;
			while(i >= 0 && s.charAt(i) <= ' '){
				i--;
			}
			s = s.substring(0, i + 1);
		}
		return s;
	}
	
	public static final String ANSI_CHARSET = "ISO8859-1";
	
	public static final String GBK_CHARSET = "GBK";
	
	public static final String EMPTY_STRING = "";
	
	/**
	 * 命名就是toString
	 * @param obj
	 * @return
	 */
	public static String toStringBuild(Object obj) {
		return (obj == null) ? "[null]" : new StringBuffer("[").append(
				obj.getClass().getName()).append("]").append(obj.toString())
				.toString();
	}
	
	/**
	 * 将字符串首个字母小写
	 * @param s
	 * @return
	 */
	public static final String lowCaseFirstChar(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}
	
	/**
	 * 首个字母大写
	 * @param s
	 * @return
	 */
	public static final String upperCaseFirstChar(String s) {
		if(s == null || s.length() == 0){
			return s;
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
	
	/**
	 * @param s
	 * @return 将GBK字符串转换为ISO8859_1的字符串
	 * @deprecated
	 */
	public static final String fromISO8859_1(String s) {
		try{
			return new String(s.getBytes(GBK_CHARSET), ANSI_CHARSET);
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			return s;
		}
	}
	
	/**
	 * 导出String到文件
	 * @param s
	 * @param exportFileName
	 * @throws IOExceptoin
	 */
	public static final void exportToFile(String s, String exportFileName) throws IOException {
		FileWriter fw = new FileWriter(exportFileName);
		BufferedWriter writer = new BufferedWriter(fw);
		writer.write(s);
		writer.flush();
		writer.close();
	}
	
	/**
	 * @param src
	 * @return 将GBK 转换为Unicode Ascii
	 */
	public static final String gbkToUnicodeStyle(String src) {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < src.length(); i++){
			buffer.append("\\u" + Integer.toHexString(src.charAt(i)));
		}
		return buffer.toString();
	}
	
	/**
	 * ANSI 转换成GBK
	 * @param ansiString
	 * @return
	 */
	public static final String ANSIStringToGBKString(String ansiString) {
		if(ansiString == null)
			return null;
		byte[] bs;
		try{
			bs = ansiString.getBytes(ANSI_CHARSET);
			return new String(bs, GBK_CHARSET);
		}catch(UnsupportedEncodingException e){
			throw new AssertionError(e.getLocalizedMessage());
		}
	}
	
	/**
	 * @param objs
	 * @param linkString
	 * @return 将objs数组转化成String，链接到<code>linkString</code>
	 */
	public static final String joinObjectArray(Object[] objs, String linkString) {
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < objs.length; i++){
			if(i != 0){
				result.append(linkString);
			}
			result.append(objs[i].toString());
		}
		return result.toString();
	}
	
	/**
	 * @param c
	 * @param linkString
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static final String joinCollection(Collection c, String linkString) {
		StringBuffer result = new StringBuffer();
		boolean ff = false;
		for(java.util.Iterator iter = c.iterator(); iter.hasNext();){
			if(ff) {
				result.append(linkString);
			}else{
				ff = true;
			}
			result.append(iter.next());
		}
		return result.toString();
	}
	
	public static final String repeat(String s, int n) {
		StringBuffer buffer = new StringBuffer(s.length() * n);
		
		for(int i = 0; i < n; i++){
			buffer.append(s);
		}
		return buffer.toString();
	}
	
	/**
	 * 使用Url编码
	 * @param msg
	 * @return
	 */
	public static String UrlANSIEncode(String msg) {
		try{
			return URLEncoder.encode(msg, ANSI_CHARSET);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			throw new AssertionError("no this Error for" + e);
		}
	}
	
	/**
	 * @param string
	 * @return 从字符串中检查出第一个词组
	 */
	public static final String checkFirstWord(String string) {
		for(int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if(c < 0x20){
				return string.substring(0, i);
			}
		}
		return string;
	}
	
	/**
	 * @param source 原数据
	 * @param splitter 分隔符
	 * @return 分隔后的数组
	 */
	public final static String[] spliteToken(String source, String splitter) {
		String[] u = null;
		int i = 0;
		for(StringTokenizer s = new StringTokenizer(source, splitter); s.hasMoreElements();){
			String tmp = s.nextToken();
			if(u == null)
				u = new String[s.countTokens() + 1]; //这里表示有多少个分割符号，所以要+1
			u[i++] = tmp;
		}
		return u;
	}
	
	/**
	 * 判断字符串是否为null或者字符串
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(final String str) {
		if(str == null || str.length() <= 0)
			return true;
		return false;
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(final String str){
		if(str != null && str.length() > 0)
			return true;
		return false;
	}
	
	/**
	 * 获取包含中文字符的实际长度</br>
	 * 中文字符串长度的转换的规则以case进行转换:</br>
	 * <li> case == 0 代表以gbk的计算规则进行计算</br>
	 * <li> case == 1 代表以java utf-8规则进行计算</br>
	 * 其他情况按默认情况计算长度</br>
	 * @param str</br>
	 * @param cases 0 代表gbk 1代表utf8</br>
	 * @return
	 */
	public static int length(String str, int cases){
		if(isEmpty(str)){
			return -1;
		}
		int valueLength = 0;
		String chinese = "[\u4E00-\u9FA5]";
		if(cases != 0 && cases != 1){
			return str.length();
		}
		
		for(int i = 0; i < str.length(); i++){
			String temp = str.substring(i, i + 1);
			if(temp.matches(chinese)){
				if(cases == 0){ //gbk 字符串长度加2
					valueLength += 2;
				}else{ //utf-8字符串长度加3
					valueLength += 3;
				}
			}else{
				valueLength += 1;// 其他字符串的长度
			}
		}
		return valueLength;
	}
	
	/**
	 * @param str
	 * @return 判断是否为null或者为空
	 */
	public static final boolean isNullorEmpty(String str) {
		return str == null || str.trim().length() <= 0;
	}
	
	/**
	 * @param str
	 * @param maxLength
	 * @return 以gbk的字符集进行截取
	 */
	public static final String gbkTruncate(String str, int maxLength) {
		if (isNullorEmpty(str))
			return null;
		int length = length(str, 0);
		if (length <= maxLength)
			return str;
		
		int retLength = 0;
		StringBuffer sb = new StringBuffer();
		for (Character c : str.toCharArray()) {
			if (isChineseCharacter(c)) 
				retLength += 2;
			else 
				retLength +=1;
			if (retLength > maxLength)
				break;
			else 
				sb.append(c);
		}
		
		return sb.toString();
	}
	
	/**
	 * @param str
	 * @param maxLength
	 * @return 以utf8的字符集进行截取
	 */
	public static final String utf8Truncate(String str, int maxLength) {
		if (isNullorEmpty(str))
			return null;
		int length = length(str, 0);
		if (length <= maxLength)
			return str;
		
		int retLength = 0;
		StringBuffer sb = new StringBuffer();
		for (Character c : str.toCharArray()) {
			if (isChineseCharacter(c)) 
				retLength += 3;
			else 
				retLength +=1;
			if (retLength > maxLength)
				break;
			else 
				sb.append(c);
		}
		
		return sb.toString();
	}
	
	private static boolean isChineseCharacter(Character c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		} else {
			return false;
		}
	}
}
