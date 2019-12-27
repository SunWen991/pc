package com.heidian.backstage.service;

import com.heidian.backstage.dao.KeywordDao;
import com.heidian.backstage.domain.Keyword;
import com.heidian.reptile.JSUtil;
import com.heidian.reptile.WeiBoProcessor;
import com.yaoren.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @date ：Created in 2019/11/8 15:32
 * @description：用户服务类
 * @modified By：
 * @version: 1.0.0$
 */

@Service
public class KeywordService extends BaseServiceImpl<Keyword, String> {

    /**
     * 员工管理数据访问对象
     */
    @Autowired
    private KeywordDao keywordDao;

    public List<String> pc() {

        String url = "https://s.weibo.com/top/summary?cate=realtimehot";
        List<String> kwList = null;
        List<String> urlList = null;
        List<String> new_url_list=new ArrayList<>();
        try {
            String html = JSUtil.getParseredHtml2(url);
            kwList = WeiBoProcessor.getDateList("//*[@id=\"pl_top_realtimehot\"]/table/tbody/tr/td[2]/a/text()", html);
            urlList = WeiBoProcessor.getDateList("//*[@id=\"pl_top_realtimehot\"]/table/tbody/tr/td[2]/a/@href", html);
            if (kwList != null && urlList != null && kwList.size() == urlList.size()) {
                Keyword keyword = null;
                int i = 0;
                for (String str : kwList) {
                    keyword = new Keyword();
                    keyword.setWord(str);
                    keyword.setUrl(urlList.get(i));
                    if (keywordDao.count(keyword)==0){  //有关键词更新
                        new_url_list.add(urlList.get(i));
                        keywordDao.save(keyword);
                    }
                    i++;
                }
            }

        } catch (IOException e) {
            return null;
        }

        //keywordDao.save(keyword);
        return new_url_list;
    }


}
