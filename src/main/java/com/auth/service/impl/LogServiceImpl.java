package com.auth.service.impl;

import com.auth.dao.DbUtil;
import com.auth.pojo.BusinessLog;
import com.auth.service.LogService;
import com.auth.vo.Page;
import com.auth.vo.SearchFilter;
import lombok.Data;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by yuxb on 16/7/1.
 */
@Service
@Data
public class LogServiceImpl implements LogService {
    @Autowired
    private DbUtil dbUtil;

    @Override
    @Async
    public void save(BusinessLog log) {
        dbUtil.getHibernateDao().save(log);
    }
    @Override
    public void delete(Long id) {
        dbUtil.getHibernateDao().deleteById(BusinessLog.class,id);
    }

    @Override
    public Page<BusinessLog> queryPage(SearchFilter searchFilter) {
        DetachedCriteria detachedCriteria = searchFilter.getDetachedCriteria(BusinessLog.class);
        return dbUtil.getHibernateDao().queryPage(detachedCriteria,null,searchFilter.getPageSize(),searchFilter.getPageNo(),true,true);

    }


}
