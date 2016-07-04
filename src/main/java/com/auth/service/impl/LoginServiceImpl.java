package com.auth.service.impl;

import com.auth.dao.HibernateDao;
import com.auth.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yuxb on 16/5/31.
 */
@Data
public class LoginServiceImpl {
    @Autowired
    HibernateDao hibernateDao;

    @Autowired
    UserService userService;

    public boolean login(String loginName, String password){

        return true;

    }
}
