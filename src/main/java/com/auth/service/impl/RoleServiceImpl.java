package com.auth.service.impl;

import com.auth.dao.DbUtil;
import com.auth.pojo.Organization;
import com.auth.pojo.Role;
import com.auth.service.RoleService;
import com.auth.vo.Page;
import com.auth.vo.SearchFilter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Created by yuxb on 16/5/17.
 */
@Data
@Slf4j
@Service(value = "roleService")
@Transactional

public class RoleServiceImpl implements RoleService {

    @Autowired
    private DbUtil dbUtil;


    @Override
    public void save(Role role) {
        dbUtil.getHibernateDao().save(role);
    }

    @Override
    public void delete(Long id) {
        dbUtil.getHibernateDao().deleteById(Role.class,id);
    }

    @Override
    public void update(Role role) {
        dbUtil.getHibernateDao().update(role);
    }

    @Override
    public Role getRoleById(Long id){
        return dbUtil.getHibernateDao().get(Role.class,id);
    }

    @Override
    public List<Role> getListByProperty(Map<String, Object> queryMap) {
        return dbUtil.getHibernateDao().findByMap(Role.class,queryMap);
    }


    @Override
    public void updateBySql(String sql, Object... params) {
        dbUtil.getJdbcDao().update(sql,params);
    }


    @Override
    public Page<Role> queryPage(SearchFilter searchFilter) {
        DetachedCriteria detachedCriteria = searchFilter.getDetachedCriteria(Organization.class);
        return dbUtil.getHibernateDao().queryPage(detachedCriteria,null,searchFilter.getPageSize(),searchFilter.getPageNo(),true,true);
    }
}
