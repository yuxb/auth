package com.auth.service;

import com.auth.pojo.Resource;
import com.auth.pojo.RoleResource;
import com.auth.vo.Page;
import com.auth.vo.SearchFilter;

import java.util.List;

/**
 * Created by yuxb on 16/6/30.
 */
public interface ResourceService {
        List<Resource>  list();
        void add(Resource resource);
        void update(Resource resource);
        void delete(Long id);

        Resource load(Long id);
        List<Resource> getByTypeAndLevel(String type,int level);
        Page<Resource> queryPage(SearchFilter searchFilter);
}

