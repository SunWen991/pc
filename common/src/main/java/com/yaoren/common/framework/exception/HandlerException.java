package com.yaoren.common.framework.exception;

import com.yaoren.common.base.domain.ResultBean;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理
 * Created by yingda.wang on 2018/3/31
 */
@ControllerAdvice
public class HandlerException {

    /**
     * 接口有参数未传
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultBean missActionParam(HttpServletRequest req, MissingServletRequestParameterException e) throws Exception {
        return makeErrorObj("接口有参数未传", req, e);
    }
//
//    /**
//     * 加密解密错误
//     */
//    @ExceptionHandler(value = CryptException.class)
//    @ResponseBody
//    public JSONObject cryptError(HttpServletRequest req, CryptException e) throws Exception {
//        return makeErrorObj("加密解密有误", req, e);
//    }

    /**
     * 数字格式错误
     */
    @ExceptionHandler(value = NumberFormatException.class)
    @ResponseBody
    public ResultBean numberFormatError(HttpServletRequest req, NumberFormatException e) throws Exception {
        return makeErrorObj("数字格式错误", req, e);
    }

//    /**
//     * JSON格式解析错误
//     */
//    @ExceptionHandler(value = JSONException.class)
//    @ResponseBody
//    public ResultBean jsonError(HttpServletRequest req, JSONException e) throws Exception {
//        return makeErrorObj("JSON格式解析错误", req, e);
//    }

    /**
     * 服务器内部错误
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBean nullError(HttpServletRequest req, NullPointerException e) throws Exception {
        return makeErrorObj("服务器内部错误", req, e);
    }

//    /**
//     * HTTP请求外部服务失败
//     */
//    @ExceptionHandler(value = HTTPConnException.class)
//    @ResponseBody
//    public JSONObject requestError(HttpServletRequest req, HTTPConnException e) throws Exception {
//        return makeErrorObj("HTTP请求外部服务失败", req, e);
//    }


    /**
     * 未知错误
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBean scheduleError(HttpServletRequest req, Exception e) throws Exception {
        return makeErrorObj("未知错误", req, e);
    }

    /**
     * 构造错误信息
     *
     * @param msg 错误描述
     * @param e   异常信息
     * @return
     */
    private ResultBean makeErrorObj(String msg, HttpServletRequest req, Exception e) {
        e.printStackTrace();
        return new ResultBean(-1, msg);
    }


}
