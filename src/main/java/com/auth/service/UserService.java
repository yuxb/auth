
package com.auth.service;


import com.auth.pojo.User;
import com.auth.vo.Page;
import com.auth.vo.SearchFilter;
import org.springframework.ui.Model;


import java.util.List;
import java.util.Map;

/**
 * Created by yuxb on 16/5/17.
 */

public interface UserService {

    void save(User user);

    void delete(Long id);

    void update(User user);

    void updateBySql(String sql, Object... params);

    List<User> getUserListByProperty(Map<String, Object> queryMap);

    User getUserById(Long id);
    Page<User> queryPage(SearchFilter searchFilter);
    User getUserByLoginName(String loginName);
}
