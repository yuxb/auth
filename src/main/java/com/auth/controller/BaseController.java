package com.auth.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static javafx.scene.input.KeyCode.R;

/**
 * Created by yuxb on 5/12/16.
 */
public class BaseController {
    @RequestMapping(value = "/{type}/{model}/{page}")
    public String goPage(@PathVariable String type,@PathVariable String model,@PathVariable String page) {

        return "/"+type+"/"+model+"/"+page;
    }

    @InitBinder(value = "searchFilter")
    public void binderSearchFilter(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("searchFilter.");
    }
}
