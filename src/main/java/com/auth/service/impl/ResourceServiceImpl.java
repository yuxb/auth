package com.auth.service.impl;

import com.auth.dao.DbUtil;
import com.auth.pojo.Resource;
import com.auth.service.ResourceService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yuxb on 16/6/30.
 */
@Service
@Data
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
        dbUtil.getHibernateDao().save(resource);
    }

    @Override
    public void update(Resource resource) {
        dbUtil.getHibernateDao().update(resource);
    }

    @Override
    public void delete(Long id) {
        dbUtil.getHibernateDao().deleteById(Resource.class,id);
    }


}
