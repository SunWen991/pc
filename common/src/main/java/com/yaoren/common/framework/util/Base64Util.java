package com.yaoren.common.framework.util;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * base64编码解码工具类
 * @author zxh
 *
 */
public class Base64Util {
	 private static char[] base64EncodeChars = new char[] {  
	       'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',  
	       'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',  
	       'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',  
	       'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',  
	       'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',  
	       'o', 'p', 'q', 'r', 's', 't', 'u', 'v',  
	       'w', 'x', 'y', 'z', '0', '1', '2', '3',  
	       '4', '5', '6', '7', '8', '9', '+', '/' };  
	  
	   private static byte[] base64DecodeChars = new byte[] {  
	   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  
	   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  
	   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,  
	   52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,  
	   -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,  
	   15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,  
	   -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,  
	   41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };  
	   //编码
	   public static String encode(byte[] data) {  
	       StringBuffer sb = new StringBuffer();  
	       int len = data.length;  
	       int i = 0;  
	       int b1, b2, b3;  
	  
	       while (i < len) {  
	           b1 = data[i++] & 0xff;  
	           if (i == len) {  
	               sb.append(base64EncodeChars[b1 >>> 2]);  
	               sb.append(base64EncodeChars[(b1 & 0x3) << 4]);  
	               sb.append("==");  
	               break;  
	           }  
	           b2 = data[i++] & 0xff;  
	           if (i == len) {  
	               sb.append(base64EncodeChars[b1 >>> 2]);  
	               sb.append(  
	                       base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);  
	               sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);  
	               sb.append("=");  
	               break;  
	           }  
	           b3 = data[i++] & 0xff;  
	           sb.append(base64EncodeChars[b1 >>> 2]);  
	           sb.append(  
	                   base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);  
	           sb.append(  
	                   base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);  
	           sb.append(base64EncodeChars[b3 & 0x3f]);  
	       }  
	       return sb.toString();  
	   }  
	   //解码
	   public static byte[] decode(String str) {  
	       byte[] data = str.getBytes();  
	       int len = data.length;  
	       ByteArrayOutputStream buf = new ByteArrayOutputStream(len);  
	       int i = 0;  
	       int b1, b2, b3, b4;  
	  
	       while (i < len) {  
	  
	             
	           do {  
	               b1 = base64DecodeChars[data[i++]];  
	           } while (i < len && b1 == -1);  
	           if (b1 == -1) {  
	               break;  
	           }  
	  
	             
	           do {  
	               b2 = base64DecodeChars[data[i++]];  
	           } while (i < len && b2 == -1);  
	           if (b2 == -1) {  
	               break;  
	           }  
	           buf.write((int) ((b1 << 2) | ((b2 & 0x30) >>> 4)));  
	  
	             
	           do {  
	               b3 = data[i++];  
	               if (b3 == 61) {  
	                   return buf.toByteArray();  
	               }  
	               b3 = base64DecodeChars[b3];  
	           } while (i < len && b3 == -1);  
	           if (b3 == -1) {  
	               break;  
	           }  
	           buf.write((int) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));  
	  
	             
	           do {  
	               b4 = data[i++];  
	               if (b4 == 61) {  
	                   return buf.toByteArray();  
	               }  
	               b4 = base64DecodeChars[b4];  
	           } while (i < len && b4 == -1);  
	           if (b4 == -1) {  
	               break;  
	           }  
	           buf.write((int) (((b3 & 0x03) << 6) | b4));  
	       }  
	       return buf.toByteArray();  
	   }  
	   
	   public static void main(String[] args){
		   StringBuffer  a = new StringBuffer();
		   //a.append("eyJDb21tb2RpdHlMaXN0IjpbeyJiYXJjb2RlIjoiSzE1MjA2MjIyODAxMDAwIiwiaXRlbW5hbWUiOiLmrL7lvI/lkI3np7AiLCJpdGVtZW5nbmFtZSI6IiIsImJyYW5kIjoieHh4IiwicHJpY2UiOjEuMDAsIml0ZW10eXBlIjoiRkciLCJlcXVhbGl0ZW1pZCI6IiIsImVxdWFsaXRlbW5hbWUiOiIiLCJzaGVsZmxpZmUiOjAsInNlcmlhbGNvbnRyb2x0YWciOiJOIiwibG90Y29udHJvbHRhZyI6Ik4iLCJpdGVtY2xhc3NubyI6IiIsIml0ZW1jbGFzc25hbWUiOiIiLCJtYWludW5pdCI6IuS7tiIsImxlbmd0aCI6IiIsIndpZHRoIjoiIiwiaGVpZ2h0IjoiIiwid2VpZ2h0IjoiIiwic3R5bGUiOiJLMTUyMDYyMjI4IiwiY29sb3IiOiLnsbPnmb0iLCJzaXplIjoiRiIsImlmUGFja2FnZSI6MSwib3JpZ2luIjoiIiwicGFja21hdGFnIjoiTiIsIm1lbW8iOiIifSx7ImJhcmNvZGUiOiJLMTUyMDYyMjI4MDMzMDAiLCJpdGVtbmFtZSI6IuasvuW8jWQjeensCIsIml0ZW1lbmduYW1lIjoiIiwiYnJhbmQiOiJ4eHgiLCJwcmljZSI6MS4wMCwiaXRlbXR5cGUiOiJGRyIsImVxdWFsaXRlbWlkIjoiIiwiZXF1YWxpdGVtbmFtZSI6IiIsInNoZWxmbGlmZSI6MCwic2VyaWFsY29udHJvbHRhZyI6Ik4iLCJsb3Rjb250cm9sdGFnIjoiTiIsIml0ZW1jbGFzc25vIjoiIiwiaXRlbWNsYXNzbmFtZSI6IiIsIm1haW51bml0Ijoi5Lu2IiwibGVuZ3RoIjoiIiwid2lkdGgiOiIiLCJoZWlnaHQiOiIiLCJ3ZWlnaHQiOiIiLCJzdHlsZSI6IksxNTIwNjIyMjgiLCJjb2xvciI6IuWkpe6oiIsInNpemUiOiJGIiwiaWZQYWNrYWdlIjoxLCJvcmlnaW4iOiIiLCJwYWNrbWF0YWciOiJOIiwibWVtbyI6IiJ9XX0=");
		   a.append("eyJDb21tb2RpdHlMaXN0IjpbeyJiYXJjb2RlIjoiVEcxNkwwMDAxIiwiaXRlbW5hbWUiOiJNaXNoa2FOWUMyMDE2IOe7v+ecvOeQg+ezluaenCIsIml0ZW1lbmduYW1lIjoiVEcxNkwiLCJicmFuZCI6Ik1pc2hrYSIsInByaWNlIjoiMCIsIml0ZW10eXBlIjoiRkciLCJlcXVhbGl0ZW1pZCI6IiIsImVxdWFsaXRlbW5hbWUiOiIiLCJzaGVsZmxpZmUiOiIwIiwic2VyaWFsY29udHJvbHRhZyI6Ik4iLCJsb3Rjb250cm9sdGFnIjoiTiIsIml0ZW1jbGFzc25vIjoiMTAxMSIsIml0ZW1jbGFzc25hbWUiOiLotaDlk4EiLCJtYWludW5pdCI6IuS7tiIsImxlbmd0aCI6IjAiLCJ3aWR0aCI6IjAiLCJoZWlnaHQiOiIwIiwid2VpZ2h0IjoiMCIsInN0eWxlIjoi57OW5p6cfDAwMDEiLCJzdHlsZUNvZGUiOiI2Mzg2IiwiY29sb3IiOiIiLCJjb2xvckNvZGUiOiIiLCJzaXplIjoiIiwiaWZQYWNrYWdlIjoiMCIsIm9yaWdpbiI6IiIsInBhY2ttYXRhZyI6Ik4iLCJiYWsxIjoiIiwiYmFrMiI6IiIsImJhazMiOiIiLCJiYWs0IjoiIiwiYmFrNSI6IiIsImJhazYiOiIiLCJiYWs3IjoiIiwiYmFrOCI6IiIsIm1lbW8iOiIifV19");
		   System.out.println("eyJDb21tb2RpdHlMaXN0IjpbeyJiYXJjb2RlIjoiVEcxNkwwMDAxIiwiaXRlbW5hbWUiOiJNaXNoa2FOWUMyMDE2IOe7v+ecvOeQg+ezluaenCIsIml0ZW1lbmduYW1lIjoiVEcxNkwiLCJicmFuZCI6Ik1pc2hrYSIsInByaWNlIjoiMCIsIml0ZW10eXBlIjoiRkciLCJlcXVhbGl0ZW1pZCI6IiIsImVxdWFsaXRlbW5hbWUiOiIiLCJzaGVsZmxpZmUiOiIwIiwic2VyaWFsY29udHJvbHRhZyI6Ik4iLCJsb3Rjb250cm9sdGFnIjoiTiIsIml0ZW1jbGFzc25vIjoiMTAxMSIsIml0ZW1jbGFzc25hbWUiOiLotaDlk4EiLCJtYWludW5pdCI6IuS7tiIsImxlbmd0aCI6IjAiLCJ3aWR0aCI6IjAiLCJoZWlnaHQiOiIwIiwid2VpZ2h0IjoiMCIsInN0eWxlIjoi57OW5p6cfDAwMDEiLCJzdHlsZUNvZGUiOiI2Mzg2IiwiY29sb3IiOiIiLCJjb2xvckNvZGUiOiIiLCJzaXplIjoiIiwiaWZQYWNrYWdlIjoiMCIsIm9yaWdpbiI6IiIsInBhY2ttYXRhZyI6Ik4iLCJiYWsxIjoiIiwiYmFrMiI6IiIsImJhazMiOiIiLCJiYWs0IjoiIiwiYmFrNSI6IiIsImJhazYiOiIiLCJiYWs3IjoiIiwiYmFrOCI6IiIsIm1lbW8iOiIifV19".equals("ezluaenCIsIml0ZW1lbmduYW1lIjoiVEcxNkwiLCJicmFuZCI6Ik1pc2hrYSIsInByaWNlIjoiMCIsIml0ZW10eXBlIjoiRkciLCJlcXVhbGl0ZW1pZCI6IiIsImVxdWFsaXRlbW5hbWUiOiIiLCJzaGVsZmxpZmUiOiIwIiwic2VyaWFsY29udHJvbHRhZyI6Ik4iLCJsb3Rjb250cm9sdGFnIjoiTiIsIml0ZW1jbGFzc25vIjoiMTAxMSIsIml0ZW1jbGFzc25hbWUiOiLotaDlk4EiLCJtYWludW5pdCI6IuS7tiIsImxlbmd0aCI6IjAiLCJ3aWR0aCI6IjAiLCJoZWlnaHQiOiIwIiwid2VpZ2h0IjoiMCIsInN0eWxlIjoi57OW5p6cfDAwMDEiLCJzdHlsZUNvZGUiOiI2Mzg2IiwiY29sb3IiOiIiLCJjb2xvckNvZGUiOiIiLCJzaXplIjoiIiwiaWZQYWNrYWdlIjoiMCIsIm9yaWdpbiI6IiIsInBhY2ttYXRhZyI6Ik4iLCJiYWsxIjoiIiwiYmFrMiI6IiIsImJhazMiOiIiLCJiYWs0IjoiIiwiYmFrNSI6IiIsImJhazYiOiIiLCJiYWs3IjoiIiwiYmFrOCI6IiIsIm1lbW8iOiIifV19"));
		   try {
			System.out.println(new String(Base64Util.decode(a.toString()), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
		}
	   }
	}