package com.auth.service.impl;

import com.auth.dao.DbUtil;
import com.auth.pojo.Resource;
import com.auth.pojo.Role;
import com.auth.pojo.RoleResource;
import com.auth.service.ResourceService;
import com.auth.util.App;
import com.auth.util.Auth;
import com.auth.vo.Page;
import com.auth.vo.SearchFilter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javafx.scene.input.KeyCode.R;

/**
 * Created by yuxb on 16/6/30.
 */
@Data
@Slf4j
@Service(value = "resourceService")
@Transactional
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private  DbUtil dbUtil;

    @Override
    public List<Resource> list() {
        return dbUtil.getHibernateDao().getALl(Resource.class);
    }

    @Override
    public void add(Resource resource) {
//
//        resource=new Resource();
//        resource.setId(App.generateId());
//        resource.setName("日志管理");
//        resource.setKey("LOG_MANAGE");
//        resource.setType(Auth.ResourceType.MENU);
//        resource.setLevel(Auth.ResourceLevel.FIRST);
//
//        Resource resource2=new Resource();
//        resource2.setId(App.generateId());
//        resource2.setName("登录日志");
//        resource2.setKey("LOGIN_LOG_MANGEE");
//        resource2.setParent(resource);
//        resource2.setType(Auth.ResourceType.MENU);
//        resource2.setLevel(Auth.ResourceLevel.SECOND);
//
//
//
//        dbUtil.getHibernateDao().save(resource);
//        dbUtil.getHibernateDao().save(resource2);
    }

    @Override
    public void update(Resource resource) {
        dbUtil.getHibernateDao().update(resource);
    }

    @Override
    public void delete(Long id) {
        dbUtil.getHibernateDao().deleteById(Resource.class,id);
    }

    @Override
    public Resource load(Long id){

        Resource resource= dbUtil.getHibernateDao().load(Resource.class,id);
        Set<RoleResource> set=resource.getRoleResources();
        return resource;
    }

    @Override
    public List<Resource> getByTypeAndLevel(String type,int level) {
        return dbUtil.getHibernateDao().getListByHQL("from Resource where type=? and level=?",type,level);
    }

    @Override
    public Page<Resource> queryPage(SearchFilter searchFilter) {
        System.out.println(searchFilter.getPageSize()+" pageno  "+
        searchFilter.getPageNo());
        return dbUtil.getHibernateDao().queryPage(searchFilter.getDetachedCriteria(Resource.class),null,
                searchFilter.getPageSize(),searchFilter.getPageNo(),false,true);
    }


}
