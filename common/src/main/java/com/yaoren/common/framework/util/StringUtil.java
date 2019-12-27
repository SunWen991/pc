package com.yaoren.common.framework.util;
/** 
 * @author  zxh
 * @date 2017-6-21 上午10:45:30 
 * @version 1.0   
 */
public class StringUtil {
	/**
	 * 空对象转空字符串,非空对象转字符串
	 * @param object
	 * @return
	 */
	public static String converNulltoBlank(Object object){
		return (object == null || "null".equalsIgnoreCase(object.toString())) ? "" : object.toString();
	}
	
	/**
	 * 空对象转0字符串,非空对象转字符串
	 * @param object
	 * @return
	 */
	public static String converNulltoZero(Object object){
		return object == null ? "0" : object.toString();
	}
}

