package com.yaoren.common.framework.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("configProperty")
public class ConfigProperty {

    @Value("#{setting[sid]}")
    private String sid;
    @Value("#{setting[appkey]}")
    private String appkey;
    @Value("#{setting[timestamp]}")
    private String timestamp;
    @Value("#{setting[start_time]}")
    private String start_time;
    @Value("#{setting[end_time]}")
    private String end_time;
    @Value("#{setting[secret]}")
    private String secret;
    @Value("#{setting[page_size]}")
    private String page_size;

    @Override
    public String toString() {
        return "ConfigProperty{" +
                "sid='" + sid + '\'' +
                ", appkey='" + appkey + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", secret='" + secret + '\'' +
                ", page_size='" + page_size + '\'' +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        this.page_size = page_size;
    }

    public String getAppkey() {

        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
}
