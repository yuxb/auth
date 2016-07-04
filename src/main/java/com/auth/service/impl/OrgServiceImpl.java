package com.auth.service.impl;

import com.auth.dao.DbUtil;
import com.auth.pojo.Organization;
import com.auth.service.OrgService;
import com.auth.vo.Page;
import com.auth.vo.QueryField;
import com.auth.vo.SearchFilter;
import lombok.Data;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.auth.vo.SearchFilter.newInstance;


/**
 * Created by yuxb on 16/5/17.
 */
@Service(value = "orgService")
@Transactional
@Data
public class OrgServiceImpl  implements OrgService {

    @Autowired
    private DbUtil dbUtil;


    @Override
    public void save(Organization org) {
        dbUtil.getHibernateDao().save(org);
    }

    @Override
    public void delete(Long id) {
        dbUtil.getHibernateDao().deleteById(Organization.class,id);
    }

    @Override
    public void update(Organization org) {
        dbUtil.getHibernateDao().update(org);
    }

    @Override
    public List<Organization> getListByProperty(Map<String, Object> queryMap) {
        return dbUtil.getHibernateDao().findByMap(Organization.class,queryMap);
    }

    @Override
    public Organization getOrgById(Long id) {
        return dbUtil.getHibernateDao().get(Organization.class,id);
    }

    @Override
    public void updateBySql(String sql, Object... params) {
        dbUtil.getJdbcDao().update(sql,params);
    }


    @Override
    public Page<Organization> queryPage(SearchFilter searchFilter) {
        DetachedCriteria detachedCriteria = searchFilter.getDetachedCriteria(Organization.class);
        return dbUtil.getHibernateDao().queryPage(detachedCriteria,null,searchFilter.getPageSize(),searchFilter.getPageNo(),true,true);
    }
}
