package com.yaoren.common.framework.util;

import java.security.MessageDigest;

/**
 * MD5工具类
 * @author zxh
 *
 */
public class MD5Util {
	/**
	   * MD5加密(32位)
	   * 
	   * @param instr 要加密的字符串
	   * @return 返回加密后的字符串
	   */
  public final static String encoderByMd5With32Bit(String instr) {
    char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    try {
      if (instr != null && !"".equals(instr)) {
        byte[] strTemp = instr.getBytes();
        MessageDigest mdTemp = MessageDigest.getInstance("MD5");
        mdTemp.update(strTemp);
        byte[] md = mdTemp.digest();
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
          byte byte0 = md[i];
          str[k++] = hexDigits[byte0 >>> 4 & 0xf];
          str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
      } else {
        return null;
      }
    } catch (Exception e) {
      return null;
    }
  }
  public final static String encoderByMd5With32BitUTF8(String instr) {
	    char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	    try {
	      if (instr != null && !"".equals(instr)) {
	        byte[] strTemp = instr.getBytes("UTF-8");
	        // MD5计算方法
	        MessageDigest mdTemp = MessageDigest.getInstance("MD5");
	        mdTemp.update(strTemp);
	        byte[] md = mdTemp.digest();
	        int j = md.length;
	        char str[] = new char[j * 2];
	        int k = 0;
	        for (int i = 0; i < j; i++) {
	          byte byte0 = md[i];
	          str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	          str[k++] = hexDigits[byte0 & 0xf];
	        }
	        return new String(str);
	      } else {
	        return null;
	      }
	    } catch (Exception e) {
	      return null;
	    }
	  }
  public static void main(String[] args) {
	System.out.println(MD5Util.encoderByMd5With32Bit("113.240.245.2341001Y001B20141226150355123456"));
}
}
