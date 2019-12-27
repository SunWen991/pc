package com.yaoren.common.base.controller;

import com.yaoren.common.base.constant.BaseConstants;
import com.yaoren.common.framework.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.*;


/**
 * @author zxh
 * @ClassName: BaseController
 * @Description: 控制器基类
 * @date 2014-8-7
 * extends MultiActionController
 */
@Controller
@Scope("prototype")
public class BaseController {
    protected Map<String, Object> map = new HashMap<>();
    protected static final String ROOT = "root";
    protected static final String SUCCESS = "success";

    /**
     * request对象
     */
    protected HttpServletRequest request;

    /**
     * response对象
     */
    protected HttpServletResponse response;

    /**
     * session对象
     */
    protected HttpSession session;

    /**
     * @param @return
     * @return Object
     * @throws
     * @Title: getUserInSession
     * @Description: 获取session中的用户对象
     */
    protected Object getUserInSession() {
        return session.getAttribute(BaseConstants.USER_SESSION);
    }

    /**
     * 默认构造器
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     */
    protected BaseController() {
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        response = servletWebRequest.getResponse();
        session = request.getSession(true);
    }

    protected static <T> Map<String, Object> sendList(List<T> T) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put(SUCCESS, true);
        map.put(ROOT, T);
        return map;
    }

    protected static <T> Map<String, Object> sendObj(Object T) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put(SUCCESS, true);
        map.put(ROOT, T);
        return map;
    }

    /**
     * @param @param  startTime
     * @param @param  endTime
     * @param @param  radioGroup
     * @param @param  paramMap
     * @param @return
     * @return Map<Object, Object>
     * @throws
     * @Title: setSearchTimePeriod
     * @Description: 设置查询时间区间
     */
    protected Map<Object, Object> setSearchTimePeriod(String startTime, String endTime, String radioGroup, Map<Object, Object> paramMap) {
        try {
            if (StringUtils.isNotEmpty(startTime))
                paramMap.put("startTime", DateUtil.parseDate(startTime));

            if (StringUtils.isNotEmpty(endTime))
                paramMap.put("endTime", DateUtil.addDays(DateUtil.parseDate(endTime), 1));

            if (StringUtils.isNotEmpty(radioGroup)) {
                Date date = new Date();
                if (radioGroup.equals("1")) {
                    paramMap.put("startTime", DateUtil.dateOnlyExt(date));
                    paramMap.put("endTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), 1));
                }
                if (radioGroup.equals("2")) {
                    paramMap.put("startTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), -1));
                    paramMap.put("endTime", DateUtil.dateOnlyExt(date));
                }
                if (radioGroup.equals("3")) {
                    paramMap.put("startTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), -6));
                    paramMap.put("endTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), 1));
                }
                if (radioGroup.equals("4")) {
                    paramMap.put("startTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), -30));
                    paramMap.put("endTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), 1));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return paramMap;
    }

    /**
     * @param @param  startTime
     * @param @param  endTime
     * @param @param  radioGroup
     * @param @param  paramMap
     * @param @return
     * @return Map<Object, Object>
     * @throws
     * @Title: setSearchTimePeriod
     * @Description: 设置查询时间区间(精确到秒)
     */
    protected Map<Object, Object> setSearchTimePeriodhms(String startTime, String endTime, String radioGroup, Map<Object, Object> paramMap) {
        try {
            if (StringUtils.isNotEmpty(startTime))
                paramMap.put("startTime", DateUtil.parseDate2hms(startTime));

            if (StringUtils.isNotEmpty(endTime))
                paramMap.put("endTime", DateUtil.addSeconds(DateUtil.parseDate2hms(endTime), 1));

            if (StringUtils.isNotEmpty(radioGroup)) {
                Date date = new Date();
                if (radioGroup.equals("1")) {
                    paramMap.put("startTime", DateUtil.dateOnlyExt(date));
                    paramMap.put("endTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), 1));
                }
                if (radioGroup.equals("2")) {
                    paramMap.put("startTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), -1));
                    paramMap.put("endTime", DateUtil.dateOnlyExt(date));
                }
                if (radioGroup.equals("3")) {
                    paramMap.put("startTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), -6));
                    paramMap.put("endTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), 1));
                }
                if (radioGroup.equals("4")) {
                    paramMap.put("startTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), -30));
                    paramMap.put("endTime", DateUtil.addDays(DateUtil.dateOnlyExt(date), 1));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return paramMap;
    }

    /**
     * 封装返回前端数据格式
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    protected Map responseMsgBuilder(int code, String msg, Object data) {


        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }
}
