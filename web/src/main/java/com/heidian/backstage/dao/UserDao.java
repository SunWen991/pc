package com.heidian.backstage.dao;

import com.heidian.backstage.domain.User;
import com.yaoren.common.base.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date ：Created in 2019/12/24 14:23
 * @description：微博用户
 * @modified By：
 * @version: 1.0.0$
 */
@Repository
public class UserDao extends BaseDaoImpl<User,String> {


    public User getCity(int cityId){

        return sqlSession.selectOne(statementName + "getCity",cityId);
    }
}
