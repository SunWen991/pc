package com.heidian.backstage.dao;

import com.heidian.backstage.domain.Keyword;
import com.yaoren.common.base.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * @date ：Created in 2019/11/8 15:36
 * @description：关键词（数据访问实现类）
 * @modified By：
 * @version: 1.0.0$
 */
@Repository
public class KeywordDao extends BaseDaoImpl<Keyword, String> {


    public int count(Keyword keyword) {
        return this.sqlSession.selectOne(statementName + "count", keyword);
    }
}
