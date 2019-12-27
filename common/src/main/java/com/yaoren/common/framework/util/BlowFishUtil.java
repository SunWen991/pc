package com.yaoren.common.framework.util;

import com.yaoren.common.framework.exception.EncryptionException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;


/**
 * @ClassName:BlowFishUtil
 * @author zxh
 * @version V1.0
 * @since JDK 1.7
 * @see
 */
public class BlowFishUtil {

    /**
     * byte数组转16进制字符串辅助数组
     */
    private final static char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    private final static String ALGORITHM = "Blowfish";

    /**
     * BlowFish算法加密方法
     *
     * @param content   待加密的原始内容
     * @param secretKey 通信双方约定的密钥
     * @return 加密后的消息
     * @throws EncryptionException
     */
    public static String encode(String content, String secretKey) throws EncryptionException   {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher;
        byte[] encoded;
		try {
			cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			encoded = cipher.doFinal(content.getBytes("UTF-8"));
		} catch (Exception e) {
			throw new EncryptionException("加密异常");
		}
        return bytesToHex(encoded);
    }

    /**
     * BlowFish算法解密方法
     *
     * @param message 待解密的消息
     * @param secretKey 通信双方约定的密钥
     * @return 原始内容
     * @throws EncryptionException 
     * @throws UnsupportedEncodingException 
     */
    public static String decode(String message, String secretKey) throws EncryptionException, UnsupportedEncodingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher;
        byte[] bytes;
		try {
			cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			bytes = cipher.doFinal(hexToBytes(message));
		} catch (Exception e) {
			throw new EncryptionException("解密异常");
		}
        return new String(bytes, "UTF-8");
    }

    /**
     * byte数组转化16进制字符串
     *
     * @param bytes 待转化的byte数组
     * @return 转化后的16进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * 16进制字符串转化为byte数组
     * @param str 待转化的字符串
     * @return 转化后的byte数组
     */
    private static byte[] hexToBytes(String str) {
        int len = str.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4)
                    + Character.digit(str.charAt(i + 1), 16));
        }
        return data;
    }

    public static void main(String[] args) {

        String content = "Hello World";
        String secretKey = "secretKey";

        // 加密示例代码
        String message = null;
        try {
            message = BlowFishUtil.encode(content, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Encoded message: " + message);


        // 解密示例代码
        try {
            String original = BlowFishUtil.decode(message, secretKey);
            System.out.println("original: " + original);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}