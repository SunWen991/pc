package com.heidian.backstage.controller;

import com.heidian.backstage.domain.Keyword;
import com.heidian.backstage.service.KeywordService;
import com.yaoren.common.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @date ：Created in 2019/11/8 15:21
 * @description：用户管理（控制转发层）
 * @modified By：
 * @version: 1.0.0$
 */
@Controller
@Scope("prototype")
@RequestMapping("/keyword")
public class KeywordController extends BaseController {

    @Autowired
    private KeywordService keywordService;


    /**
     * @param @param  request
     * @param @param  response
     * @param @return
     * @param @throws IOException
     * @return boolean
     * @throws
     * @Title: save
     * @Description: 保存用户
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
    public Map save(HttpServletRequest request, HttpServletResponse response) throws IOException {


        return map;
    }

    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    @ResponseBody
    public Map lisetByPage(@RequestBody Keyword keyword) {
        return responseMsgBuilder(0, "查询成功！", keywordService.listByPage(keyword));
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public List<Keyword> listAll() {

        return keywordService.listAll();
    }

    @RequestMapping(value = "/pc", method = RequestMethod.POST)
    @ResponseBody
    public Map pc() {
        //keywordService.pc(null);
        return responseMsgBuilder(0, "爬取关键词成功！", keywordService.pc());
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Map test() {
        return responseMsgBuilder(0, "测试成功！", null);
    }


}
