package com.auth.controller;

import com.auth.pojo.User;
import com.auth.service.ResourceService;
import com.auth.service.UserService;
import com.auth.util.Auth;
import com.auth.util.ServletUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by yuxb on 16/5/31.
 */
@Controller
@Data
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    ResourceService resourceService;

    /**
     * @param loginName
     * @param password
     * @return index
     */

    @RequestMapping(value = "/login", method= RequestMethod.POST)
    public String login(String loginName, String password, HttpServletRequest request){
        checkNotNull(loginName,"登陆名不能为空!");
        checkNotNull(loginName,"登陆密码不能为空!");
        request.getSession().setAttribute(Auth.CURRENT_USER,new User());
        request.setAttribute("parentMenu",resourceService.getByTypeAndLevel(Auth.ResourceType.MENU,Auth.ResourceLevel.FIRST));
        return "/admin/index";
    }
    @RequestMapping(value = "/renderLogin")
    public String renderLogin(){
        return "/common/login";
    }
}
