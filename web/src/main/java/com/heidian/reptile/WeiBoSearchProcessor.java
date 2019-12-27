package com.heidian.reptile;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ：SunWen
 * @date ：Created in 2019/12/19 14:46
 * @description：微博信息
 * @modified By：
 * @version: 1.0.0$
 */
public class WeiBoSearchProcessor implements PageProcessor {

    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
            /*addCookie("","" +
            "login_sid_t = 4 cf727ad071b41296f443d951221b401;" +
            "cross_origin_proto = SSL;" +
            "_s_tentry = passport.weibo.com;" +
            "Apache = 6563767398768.017 .1576732291495;" +
            "SINAGLOBAL = 6563767398768.017 .1576732291495;\n" +
            "ULV = 1576732291507: 1: 1: 1: 6563767398768.017 .1576732291495: ;" +
            "UOR = , , login.sina.com.cn;" +
            "appkey = ;" +
            "YF - Page - G0 = aac25801fada32565f5c5e59c7bd227b | 1576825534 | 1576825333;" +
            "SUB = _2A25w - AcxDeRhGeFO6lYX8SrMzDyIHXVTjH_5rDV8PUNbmtANLRjekW9NQZME_5EUPahiL9og1DDjyL9FnBoNPqsc;" +
            "SUBP = 0033 WrSXqPxfM725Ws9jqgMF55529P9D9W5Eo9jDMJ0cuHTxChY.axgf5JpX5KzhUgL.FoM7eKBceKB7S052dJLoI0qLxK - L1K5LB - qLxKqL1KnL12 - LxKqL1KnL1 - qLxKML1 - 2 L1hBLxK - LBKBL1 - eLxKqL1K.L1 - 2 t;" +
            "SUHB = 0x nCEMUlFtJQFc;" +
            "ALF = 1608362721;" +
            "SSOLoginState = 1576826721;" +
            "wb_view_log_7014614070 = 1366 * 7681 % 261920 * 10801;" +
            "TC - Page - G0 = 45685168 db6903150ce64a1b7437dbbb | 1576827979 | 1576827979;" +
            "webim_unReadCount = % 7 B % 22 time % 22 % 3 A1576828116823 % 2 C % 22 dm_pub_total % 22 % 3 A0 % 2 C % 22 chat_group_client % 22 % 3 A1007 % 2 C % 22 allcountNum % 22 % 3 A1007 % 2 C % 22 msgbox % 22 % 3 A0 % 7 D"
            );*/
    private static int count = 0;

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {

        /*//判断链接是否符合http://www.cnblogs.com/任意个数字字母-/p/7个数字.html格式
        if (!page.getUrl().regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[0-9]{7}.html").match()) {
            //加入满足条件的链接
            page.addTargetRequests(
                    page.getHtml().xpath("//*[@id=\"post_list\"]/div/div[@class='post_item_body']/h3/a/@href").all());
        } else {
            //获取页面需要的内容
            System.out.println("抓取的内容：" +
                    page.getHtml().xpath("//*[@id=\"Header1_HeaderTitle\"]/text()").get()
            );
            count++;
        }*/
        List<String> stringList=page.getHtml().xpath("//*[@id=\"pl_top_realtimehot\"]/table/tbody/tr/td[2]/a/text()").all();

        System.out.println("数据："+page.getRawText());
    }



    public static void main(String[] args) throws IOException {
        long startTime, endTime;
        String url="https://s.weibo.com/weibo?q=%23%E4%B8%8D%E4%B8%80%E6%A0%B7%E7%9A%84%E5%88%9B%E5%8D%9A%E4%BC%9A%23&Refer=new_time";
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        //Spider.create(new WeiBoSearchProcessor()).addUrl("https://weibo.com/p/1005053192137663/info?mod=pedit_more").thread(5).run();
        //Spider.create(new WeiBoSearchProcessor()).addUrl("https://s.weibo.com/weibo?q=%23%E7%BD%97%E5%BF%97%E7%A5%A5%E5%8F%8D%E5%AF%B9%E5%91%A8%E6%89%AC%E9%9D%92%E7%A9%BF%E6%80%A7%E6%84%9F%E8%A3%85%23&Refer=top").thread(5).run();

        //Spider.create(new WeiBoArticleProcessor()).addUrl("https://weibo.com/p/1005053192137663/info?mod=pedit_more").thread(5).run();
        // //*[@id="pl_feedlist_index"]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a[1]
        //  //*[@id="pl_feedlist_index"]/div[1]/div[2]/div[2]/div[1]/div[2]/p[1]

        List<String> stringList=WeiBoProcessor.getDateList("//*[@id=\"pl_feedlist_index\"]/div[1]/div/div/div[1]/div[2]/p[1]/text()",JSUtil.getParseredHtml2(url));
        System.out.println(stringList.get(1));
        System.out.println(stringList.get(1).replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+", ""));
        System.out.println(stringList.get(1));
        //int res=Integer.valueOf(stringList.get(1).substring(stringList.get(1).lastIndexOf(" ")+1));
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了数据：" +stringList.size());
    }
}
