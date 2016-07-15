package com.auth.service.impl;

import com.auth.dao.DbUtil;
import com.auth.pojo.Organization;
import com.auth.pojo.User;
import com.auth.service.UserService;
import com.auth.util.Util;
import com.auth.vo.Page;
import com.auth.vo.SearchFilter;
import lombok.Data;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * Created by yuxb on 16/6/9.
 */
@Service
@Transactional
@Data
public class UserServiceImpl implements UserService {
    @Autowired
    DbUtil dbUtil;


    @Override
    public void save(User user) {

        dbUtil.getHibernateDao().save(user);

    }
    @Override
    public void delete(Long id){
        dbUtil.getHibernateDao().deleteById(User.class,id);
    }
    @Override
    public void update(User user){
         dbUtil.getHibernateDao().update(user);
    }
    @Override
    public void updateBySql(String sql, Object... params) {
        dbUtil.getJdbcDao().update(sql,params);
    }
    @Override
    public List<User> getUserListByProperty(Map<String,Object> queryMap){
        return dbUtil.getHibernateDao().findByMap(User.class,queryMap);
    }

    @Override
    public User getUserById(Long id) {
        return dbUtil.getHibernateDao().get(User.class,id);
    }

    @Override
    public Page<User> queryPage(SearchFilter searchFilter) {
        DetachedCriteria detachedCriteria = searchFilter.getDetachedCriteria(User.class);
        return dbUtil.getHibernateDao().queryPage(detachedCriteria,null,searchFilter.getPageSize(),searchFilter.getPageNo(),true,true);

    }

    @Override
    public User getUserByLoginName(String loginName) {
        return (User) dbUtil.getHibernateDao().getByHQL("from User where loginName=?",loginName);
    }
}
