package com.auth.controller;

import com.auth.service.ResourceService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yuxb on 16/6/29.
 */
@Controller
@RequestMapping(value = "/res")
@Data
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request){
        request.setAttribute("resources",resourceService.list());

        return "/admin/res/list";
    }


}
