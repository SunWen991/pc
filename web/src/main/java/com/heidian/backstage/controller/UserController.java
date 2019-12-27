package com.heidian.backstage.controller;

import com.heidian.backstage.domain.User;
import com.heidian.backstage.service.UserService;
import com.yaoren.common.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @date ：Created in 2019/12/24 14:25
 * @description：微博用户
 * @modified By：
 * @version: 1.0.0$
 */
@Controller
@Scope("prototype")
@RequestMapping("/userMsg")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map save(){
        return responseMsgBuilder(0,"保存数据成功！",userService.save());

    }

    @RequestMapping(value = "/listAll",method = RequestMethod.POST)
    @ResponseBody
    public List<User> listAll(){
        return userService.listAll();
    }

}
