package com.yaoren.common.framework.util.str_dispose;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrDispose {

    /**
     * URL编码
     * @param str
     * @return
     */
    public static String urlEnoder(String str){
        try {
            return URLEncoder.encode(str,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 升序排列
     * @param s
     * @return
     */
    public static String[] stringSort(String [] s) {
        List<String> list = new ArrayList<String>(s.length);
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        Collections.sort(list);
        return list.toArray(s);
    }
}
