package com.auth.controller;


import com.auth.pojo.User;
import com.auth.service.UserService;
import com.auth.vo.Page;
import com.auth.vo.ResponseEntity;
import com.auth.vo.SearchFilter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


/**
 * Created by yuxb on 16/5/27.
 */
@RestController
@Data
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/user/add",method = RequestMethod.POST)
    public ResponseEntity add(User user){
        user.setId(System.currentTimeMillis());
        userService.save(user);
        ResponseEntity responseEntity =new ResponseEntity();
        responseEntity.setCode("200");
        responseEntity.setInfo("操作成功");
        return responseEntity;
    }
    @RequestMapping(value = "/user/{id}")
    public User getUserById(@PathVariable ("id") Long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "users/list")
    public Page<User> queryPage(SearchFilter searchFilter){
        return userService.queryPage(searchFilter);
    }

}
