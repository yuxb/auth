package com.auth.service;

import com.auth.pojo.Resource;

import java.util.List;

/**
 * Created by yuxb on 16/6/30.
 */
public interface ResourceService {
        List<Resource>  list();
        void add(Resource resource);
        void update(Resource resource);
        void delete(Long id);
}

