package com.heidian.backstage.domain;

import com.yaoren.common.base.domain.BaseSearchInfo;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @date ：Created in 2019/11/8 15:24
 * @description：用户实体类
 * @modified By：
 * @version: 1.0.0$
 */
@Component("User")
public class User extends BaseSearchInfo {

    private long userId;
    private String userName;
    private String sex;
    private String district;
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


}
