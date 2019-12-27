package com.yaoren.common.framework.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5AndKeyUtil {
    public static String getMd5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String EncoderByMd5(String str) {
        String result = "";
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            // 这句是关键
            md5.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte b[] = md5.digest();
        int i;
        StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0)
                i += 256;
            if (i < 16)
                buf.append("0");
            buf.append(Integer.toHexString(i));
        }
        result = buf.toString();

        return result;
    }

    public static void main(String[] args) {
        String mm = "userId=100&secret=yaosi001&tel=18600000000&key=yaosi";
        String mm1="06-appkey:0008-test2-xx;08-end_time:0019-2016-08-01 13:00:00;07-page_no:0001-0;09-page_size:0002-40;03-sid:0005-test2;"+
                "10-start_time:0019-2016-08-01 12:00:00;09-timestamp:0010-1470042310"+"12345";
        /*
         * 转换成小写后MD5加密
         */
        System.out.println(getMd5(mm1.toLowerCase()));
    }
}
