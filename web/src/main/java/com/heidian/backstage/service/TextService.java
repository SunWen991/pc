package com.heidian.backstage.service;

import com.heidian.backstage.dao.KeywordDao;
import com.heidian.backstage.dao.TextDao;
import com.heidian.backstage.domain.Keyword;
import com.heidian.backstage.domain.Text;
import com.heidian.reptile.JSUtil;
import com.heidian.reptile.WeiBoProcessor;
import com.yaoren.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @date ：Created in 2019/12/22 21:37
 * @description：文本
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class TextService extends BaseServiceImpl<Text, String> {

    @Autowired
    private TextDao textDao;

    @Autowired
    private KeywordDao keywordDao;

    @Autowired
    private KeywordService keywordService;

    //  -Dfile.encoding=UTF-8
    public int pc() throws IOException {

        List<String> url_list=keywordService.pc();
        //List<String> url_list = new ArrayList<>();
        //url_list.add("/weibo?q=%23%E4%B8%8D%E4%B8%80%E6%A0%B7%E7%9A%84%E5%88%9B%E5%8D%9A%E4%BC%9A%23&Refer=new_time");
        if (url_list == null || url_list.isEmpty()) {  //查询关键词是否更新
            return 1;
        }
        List<String> author_list = null;
        List<String> content_list = null;
        List<String> comment_list = null;
        for (String url : url_list) {
            String html = JSUtil.getParseredHtml2("https://s.weibo.com" + url);
            author_list = WeiBoProcessor.getDateList("//*[@id=\"pl_feedlist_index\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/a[1]/text()", html);  // //*[@id="pl_feedlist_index"]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/a[1]
            content_list = WeiBoProcessor.getDateList("//*[@id=\"pl_feedlist_index\"]/div[1]/div/div/div[1]/div[2]/p[1]/text()", html);  // //*[@id="pl_feedlist_index"]/div[1]/div/div[2]/div[1]/div[2]/p[1]/text()[1]

            comment_list = WeiBoProcessor.getDateList("//*[@id=\"pl_feedlist_index\"]/div[1]/div/div/div[2]/ul/li[3]/a/text()", html);  // //*[@id="pl_feedlist_index"]/div[1]/div[2]/div[2]/div[2]/ul/li[3]/a
            //System.out.println(author_list.size() + "\n" + content_list.size() + "\n" + comment_list.size());
            if (author_list != null && content_list != null && comment_list != null && author_list.size() == content_list.size() && content_list.size() == comment_list.size()) {
                Text text = null;
                int i = 0;
                String str1 = null;
                for (String str : author_list) {
                    text = new Text();
                    text.setAuthor(str);
                    //去除特殊字符内容
                    text.setContent(content_list.get(i).replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+", ""));
                    str1 = comment_list.get(i);
                    if (str1 != null && str1.length() != str1.lastIndexOf(" ") + 1) {
                        text.setCommentCount(Integer.valueOf(str1.substring(str1.lastIndexOf(" ") + 1)));
                    } else {
                        text.setCommentCount(0);
                    }
                    text.setType(1);
                    textDao.save(text);
                    i++;
                }
            }
        }
        return 0;
    }


}
