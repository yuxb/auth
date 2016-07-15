package com.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 页面跳转专用类
 * Created by yuxb on 16/6/22.
 */
@Controller
public class ForwardController {
    /***
     *页面跳转方法
     * @param path 路径
     *例:admin/user/list
     */
    @RequestMapping(value = "/load")
    public String goPage(@RequestParam("path") String path) {
        return "/"+path;
    }
}
