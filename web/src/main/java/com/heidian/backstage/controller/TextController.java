package com.heidian.backstage.controller;

import com.heidian.backstage.domain.Text;
import com.heidian.backstage.service.TextService;
import com.yaoren.common.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date ：Created in 2019/12/22 22:11
 * @description：文本数据
 * @modified By：
 * @version: 1.0.0$
 */
@Controller
@Scope("prototype")
@RequestMapping("/text")
public class TextController extends BaseController {

    @Autowired
    private TextService textService;

    @RequestMapping(value = "/pc", method = RequestMethod.POST)
    @ResponseBody
    public Map pc() {

        try {
            int res = textService.pc();
            switch (res) {
                case 0:
                    return responseMsgBuilder(0, "爬取文本数据成功！", null);
                default:
                    return responseMsgBuilder(1, "爬取文本数据失败！", null);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return responseMsgBuilder(0, "获取文本html失败！", null);
        }

    }

    @RequestMapping(value = "/listByModel", method = RequestMethod.POST)
    @ResponseBody
    public List<Text> listByModel(@RequestParam String author, @RequestParam String content, @RequestParam String page) {

        Text text = new Text();
        text.setAuthor(author);
        text.setContent(content);

        return textService.listByModel(text);
    }

    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> listByPage(@RequestParam int page, @RequestParam int rows, @RequestParam(required = false) String author, @RequestParam(required = false) String content) {

        Text text = new Text();
        text.setStart((page-1)*rows);
        text.setRows(rows);
        text.setAuthor(author);
        text.setContent(content);

        Map<String,Object> map=new HashMap<>();
        map.put("total",textService.countAll(text));
        map.put("rows",textService.listByPage(text));

        return map;
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public List<Text> listAll() {
        return textService.listAll();
    }
}
