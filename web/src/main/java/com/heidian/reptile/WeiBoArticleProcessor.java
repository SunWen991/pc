package com.heidian.reptile;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @author ：SunWen
 * @date ：Created in 2019/12/19 18:25
 * @description：微博文章
 * @modified By：
 * @version: 1.0.0$
 */
public class WeiBoArticleProcessor implements PageProcessor {

    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).addCookie("Cookie",

            "Ugrow - G0 = 140 ad66ad7317901fc818d7fd7743564;" +
                    "login_sid_t = 4 cf727ad071b41296f443d951221b401;" +
                    "cross_origin_proto = SSL;" +
                    "TC - V5 - G0 = 595 b7637c272b28fccec3e9d529f251a;" +
                    "_s_tentry = passport.weibo.com;" +
                    "Apache = 6563767398768.017 .1576732291495;" +
                    "SINAGLOBAL = 6563767398768.017 .1576732291495;" +
                    "ULV = 1576732291507: 1: 1: 1: 6563767398768.017 .1576732291495: ;" +
                    "WBtopGlobal_register_version = 307744 aa77dd5677;" +
                    "UOR = , , login.sina.com.cn;" +
                    "appkey = ;" +
                    "YF - V5 - G0 = 9903 d059c95dd34f9204f222e5a596b8;" +
                    "wb_view_log = 1366 * 7681 % 261920 * 10801;" +
                    "SUB = _2A25w - AcxDeRhGeFO6lYX8SrMzDyIHXVTjH_5rDV8PUNbmtANLRjekW9NQZME_5EUPahiL9og1DDjyL9FnBoNPqsc;" +
                    "SUBP = 0033 WrSXqPxfM725Ws9jqgMF55529P9D9W5Eo9jDMJ0cuHTxChY.axgf5JpX5KzhUgL.FoM7eKBceKB7S052dJLoI0qLxK - L1K5LB - qLxKqL1KnL12 - LxKqL1KnL1 - qLxKML1 - 2 L1hBLxK - LBKBL1 - eLxKqL1K.L1 - 2 t;" +
                    "SUHB = 0x nCEMUlFtJQFc;" +
                    "ALF = 1608362721;" +
                    "SSOLoginState = 1576826721;" +
                    "wb_view_log_7014614070 = 1366 * 7681 % 261920 * 10801;" +
                    "wvr = 6;" +
                    "TC - Page - G0 = b993e9b6e353749ed3459e1837a0ae89 | 1576832955 | 1576832884;" +
                    "webim_unReadCount = % 7 B % 22 time % 22 % 3 A1576833201705 % 2 C % 22 dm_pub_total % 22 % 3 A1 % 2 C % 22 chat_group_client % 22 % 3 A1019 % 2 C % 22 allcountNum % 22 % 3 A1020 % 2 C % 22 msgbox % 22 % 3 A0 % 7 D"

    );

    @Override
    public void process(Page page) {

        //List<String> stringList = page.getHtml().xpath("//*[@id=\"pl_top_realtimehot\"]/table/tbody/tr/td[2]/a/text()").all();
        System.out.println("数据："+page.getRawText());
    }

    @Override
    public Site getSite() {
        return site;
    }
}
