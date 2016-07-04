package com.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转专用类
 * Created by yuxb on 16/6/22.
 */
@Controller
@RequestMapping(value="/load")
public class ForwardController {
    /***
     *页面跳转方法
     * @param type 前台还是后台
     *@param model 模块
     *@param page 具体的页面
     *例:admin/user/list
     */
    @RequestMapping(value = "/{type}/{model}/{page}")
    public String goPage(@PathVariable String type, @PathVariable String model, @PathVariable String page) {
        return "/"+type+"/"+model+"/"+page;
    }
}
