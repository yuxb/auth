package com.auth.controller;

import com.auth.pojo.User;
import com.auth.service.UserService;
import com.auth.util.Auth;
import com.auth.util.ServletUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by yuxb on 16/5/31.
 */
@Controller
@Data
public class LoginController {
    @Autowired
    UserService userService;

    /**
     * @param loginName
     * @param password
     * @return index
     */

    @RequestMapping(value = "/login", method= RequestMethod.POST)
    public String login( String loginName, String password){
        checkNotNull(loginName,"登陆名不能为空!");
        checkNotNull(loginName,"登陆密码不能为空!");
        ServletUtil.getSession().setAttribute(Auth.CURRENT_USER,new User());
//        User user=userService.getUserByLoginName(loginName);
//        if (Util.isNull(user)){
//            ServletUtil.getRequest().setAttribute("error","用户登录名不存在");
//            return "/common/login";
//        }else if(!user.getPassword().equals(MD5Util.md5Encode(password))){
//            ServletUtil.getRequest().setAttribute("error","密码错误");
//            return "/common/login";
//        }
 //       ServletUtil.getSession().setAttribute("user",user);
        return "/common/index";
    }
    @RequestMapping(value = "/renderLogin")
    public String renderLogin(){
        return "/common/login";
    }
}
