package com.auth.controller;

import com.auth.pojo.Resource;
import com.auth.service.ResourceService;
import com.auth.service.RoleService;
import com.auth.util.Util;
import com.auth.vo.Page;
import com.auth.vo.SearchFilter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
   RoleService roleService;

    @InitBinder(value = "searchFilter")
    public void binderSearchFilter(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("searchFilter.");
    }
    @RequestMapping(value = "page",method = RequestMethod.GET)
    @ResponseBody
    public  Page<Resource> queryPage(SearchFilter searchFilter, HttpServletRequest request){
        return resourceService.queryPage(searchFilter);

    }
    @RequestMapping(value = "add")
    public String add(Resource resource){

        resourceService.add(resource);
        return  null;

    }
    @RequestMapping(value = {"/load/{id}"})
    public String get (@PathVariable  long id, HttpServletRequest request){
        if(Util.notNull(id)&&-1!=id){
            Resource resource= resourceService.load(id);
            request.setAttribute("bean",resource);
        }

        return "/admin/res/edit";
    }

}
