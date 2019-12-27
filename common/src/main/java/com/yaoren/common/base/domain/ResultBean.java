package com.yaoren.common.base.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yingda.wang on 2018/3/31
 */
@SuppressWarnings("unchecked")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResultBean<T extends Serializable> implements Serializable {


    private Integer code = 0;

    private String msg = "SUCCESS";

    private T data;

    public ResultBean(T data) {
        this.data = data;
    }

    public ResultBean() {

    }

//    public ResultBean(ErrorCodeEnum errorCodeEnum) {
//        code = errorCodeEnum.getCode();
//        msg = errorCodeEnum.getMsg();
//    }

    public ResultBean(String key, T data) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, data);
        this.data = (T) map;
    }

    public ResultBean(Integer errorCode, String errorMsg) {
        this.code = errorCode;
        this.msg = errorMsg;
    }

    public ResultBean(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public ResultBean<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultBean<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultBean<T> setData(T data) {
        this.data = data;
        return this;
    }


}
