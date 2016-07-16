package com.auth.service;

import com.auth.pojo.Organization;
import com.auth.pojo.Role;
import com.auth.vo.Page;
import com.auth.vo.SearchFilter;

import java.util.List;
import java.util.Map;

/**
 * Created by yuxb on 16/7/9.
 */
public interface RoleService {
    void save(Role role);

    void delete(Long id);

    void update(Role role);

    Role getRoleById(Long id);

    List<Role> getListByProperty(Map<String, Object> queryMap);

    void updateBySql(String sql, Object... params);

    Page<Role> queryPage(SearchFilter searchFilter);
}
