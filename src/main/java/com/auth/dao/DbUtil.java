package com.auth.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import static com.sun.tools.doclint.Entity.ge;

/**
 * Created by yuxb on 16/5/31.
 */
@Component
public class DbUtil {
    @Autowired
    private  HibernateDao hibernateDao;
    @Autowired
    private  JdbcDao jdbcDao;
    public  HibernateDao getHibernateDao() {
        return hibernateDao;
    }

    public void setHibernateDao(HibernateDao hibernateDao) {
        this.hibernateDao = hibernateDao;
    }

    public  JdbcDao getJdbcDao() {
        return jdbcDao;
    }

    public void setJdbcDao(JdbcDao jdbcDao) {
        this.jdbcDao = jdbcDao;
    }
}
