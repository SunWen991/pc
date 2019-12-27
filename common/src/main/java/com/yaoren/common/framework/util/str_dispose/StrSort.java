package com.yaoren.common.framework.util.str_dispose;


import com.yaoren.common.framework.util.ConfigProperty;
import com.yaoren.common.framework.util.MD5AndKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 *
 */
@Component
public class StrSort {

    @Autowired
    private ConfigProperty configProperty;

    //public  String Key[]={"sid","appkey","timestamp","start_time","end_time"};
    public  String Key[]={"sid","appkey","timestamp"};
    public String getParam(Map<String,Object> map,String key[]) throws UnsupportedEncodingException {

        String str[]=new String[Key.length+key.length];
        System.arraycopy(Key, 0, str, 0, Key.length);
        System.arraycopy(key, 0, str, Key.length, key.length);

        map.put(str[0],configProperty.getSid());
        map.put(str[1],configProperty.getAppkey());
        map.put(str[2],getSecondTimestampTwo(new Date()));
       /* map.put(str[3],configProperty.getStart_time());
        map.put(str[4],configProperty.getEnd_time());*/

        //  升序排列
        String str_[]= StrDispose.stringSort(str);
        //  拼接字符串
        StringBuilder param=new StringBuilder();
        for(int i=0;i<str_.length;i++){
            param.append(keyLength(str_[i])+"-"+str_[i]+":"
                    +valuesLength(String.valueOf( map.get(str_[i])))+"-"+map.get(str_[i]));
            if (i<str_.length-1){
                param.append(";");
            }
        }
        System.out.println(param.toString());
        //  sign签名
        map.put("sign", MD5AndKeyUtil.EncoderByMd5(param.toString() + configProperty.getSecret()));  //f7d79847b6200327aa3fc5551dc9bde9
        //System.out.println(map);

        //  URL编码
        Set<String> set=map.keySet();
        for (String str1:set){
            map.put(str1, StrDispose.urlEnoder(String.valueOf( map.get(str1))));
        }
        //  拼接请求参数
        StringBuilder param_=new StringBuilder();
        int i=0;
        for (String str1:set){
            param_.append(str1+"="+map.get(str1));
            if(i<set.size()-1){
                param_.append("&");
            }
            i++;
        }

        return param_.toString();
    }

    private String keyLength(String str){
        int length=str.length();
        if(length>9){
            return String.valueOf(length);
        }
        return "0"+length;
    }

    private String valuesLength(String str){
        int length=str.length();

        if(length<10){
            return "000"+length;
        }else if (length<100){
            return "00"+length;
        }else if (length<1000){
            return "0"+length;
        }else
            return String.valueOf(length);
    }



    /**
     * 获取精确到秒的时间戳
     * @param date
     * @return
     */
    private static String getSecondTimestampTwo(Date date){
        if (null == date) {
            return null;
        }
        //String timestamp = String.valueOf(date.getTime()/1000);
        String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis()/1000);
        //return Integer.valueOf(timestamp);
        return timestamp;
    }

}
