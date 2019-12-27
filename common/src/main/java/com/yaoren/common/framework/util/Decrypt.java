package com.yaoren.common.framework.util;

import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.security.KeyStore;

public class Decrypt {

    private static final Logger logger = Logger.getLogger( Decrypt.class);

    public static void jsencrypt(){

        byte[] bs = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            // encodePwd是前端密码使用公钥通过jscencrypt进行加密后得到的（这里也是复制github上的举例）
            String encodePwd = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQ"
                    + "DlOJu6TyygqxfWT7eLtGDwajtNFOb9I5XRb6"
                    + "khyfD1Yt3YiCgQWMNW649887VGJiGr/L5i2o"
                    + "sbl8C9+WJTeucF+S76xFxdU6jE0NQ+Z+zEdh"
                    + "UTooNRaY5nZiu5PgDB0ED/ZKBUSLKL7eibMx"
                    + "ZtMlUDHjm4gwQco1KRMDSmXSMkDwIDAQAB";
            bs = decoder.decodeBuffer(encodePwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("D:/jsencrypt/test.jks"), "123456".toCharArray());
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, keyStore.getKey("test", "123456".toCharArray()));

            System.out.println("结果："+new String(cipher.doFinal(bs)));
            //logger.info(new String(cipher.doFinal(bs)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        jsencrypt();
    }
}
