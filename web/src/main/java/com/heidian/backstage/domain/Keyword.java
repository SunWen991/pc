package com.heidian.backstage.domain;

import com.yaoren.common.base.domain.BaseSearchInfo;
import org.springframework.stereotype.Component;

/**
 * @author ：SunWen
 * @date ：Created in 2019/12/20 17:51
 * @description：微博热搜关键词
 * @modified By：
 * @version: 1.0.0$
 */
@Component
public class Keyword extends BaseSearchInfo {

    private int kwId;
    private String word;
    private String url;

    @Override
    public String toString() {
        return "Keyword{" +
                "kwId=" + kwId +
                ", word='" + word + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getKwId() {
        return kwId;
    }

    public void setKwId(int kwId) {
        this.kwId = kwId;
    }
}
