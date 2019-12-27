package com.heidian.backstage.domain;

import com.yaoren.common.base.domain.BaseSearchInfo;
import org.springframework.stereotype.Component;

/**
 * @date ：Created in 2019/12/22 20:55
 * @description：文本（文章和评论）
 * @modified By：
 * @version: 1.0.0$
 */
@Component
public class Text extends BaseSearchInfo {


    private int txId;
    private String author;
    private String content;
    private int commentCount;
    private int type;

    @Override
    public String toString() {
        return "Text{" +
                "txId=" + txId +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", commentCount=" + commentCount +
                ", type=" + type +
                '}';
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getTxId() {
        return txId;
    }

    public void setTxId(int txId) {
        this.txId = txId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
