package com.heidian.reptile;

import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * @author ：SunWen
 * @date ：Created in 2019/12/20 16:41
 * @description：解析HTML，获取数据
 * @modified By：
 * @version: 1.0.0$
 */
public class WeiBoProcessor {


    public static String  getDate(String xpath,String html){

        Html html1=new Html(html);
        String string=html1.xpath(xpath).get();

        return string;
    }

    public static List<String> getDateList(String xpath,String html){

        Html html1=new Html(html);
        List<String> stringList=html1.xpath(xpath).all();

        return stringList;
    }
}
