
package com.auth.service;


import com.auth.pojo.Organization;
import com.auth.vo.Page;
import com.auth.vo.SearchFilter;

import java.util.Map;
import java.util.List;



/**
 * Created by yuxb on 16/5/17.
 */

public interface OrgService {
    void save(Organization org);
    void delete(Long id);
    void update(Organization org);
    List<Organization> getListByProperty(Map<String,Object> queryMap);
    Organization getOrgById(Long id);
    void updateBySql(String sql,Object...params);
    Page<Organization> queryPage(SearchFilter searchFilter);

}
