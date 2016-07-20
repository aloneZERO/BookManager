package com.leo.util;

/**
 * 字符串工具类
 * @author leo
 *
 */
public class StringUtil {
	
	/**
	 * 构造方法私有化
	 */
	private StringUtil() {
		super();
	}
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断是否相等
	 * @param str_dest
	 * @param str_src
	 * @return
	 */
	public static boolean isEqual(String str_dest,final String str_src) {
		if(str_dest.trim().equals(str_src.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
