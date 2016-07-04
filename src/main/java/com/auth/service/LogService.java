package com.auth.service;


import com.auth.pojo.BusinessLog;
import com.auth.vo.Page;
import com.auth.vo.SearchFilter;

/**
 * Created by yuxb on 16/7/1.
 */
public interface LogService{
    void save(BusinessLog log);
    void delete(Long id);
    Page<BusinessLog> queryPage(SearchFilter searchFilter);
}
