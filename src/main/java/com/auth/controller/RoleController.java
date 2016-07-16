package com.auth.controller;
/**
 * Created by yuxb on 16/5/16.
 */

import com.auth.pojo.Organization;
import com.auth.pojo.Role;
import com.auth.service.RoleService;
import com.auth.util.App;
import com.auth.util.Auth;
import com.auth.vo.Page;
import com.auth.vo.ResponseEntity;
import com.auth.vo.SearchFilter;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *机构控制类
 *
 */
@Data
@Controller
@RequestMapping(value = "/role")

public class RoleController {
    @Autowired
    private RoleService roleService;

    Logger logger= LoggerFactory.getLogger(RoleController.class);
    /**
     *新增角色
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Role role) {
       
        roleService.save(role);
        return "index";
    }

    @Cacheable(value="roleList")
    @ResponseBody
    @RequestMapping(value="list",method = RequestMethod.GET)
    public ResponseEntity  getList(SearchFilter searchFilter){
        ResponseEntity responseEntity =new ResponseEntity<List<Organization>>();
        responseEntity.setCode("200");
        responseEntity.setInfo("操作成功");
        responseEntity.setData(roleService.queryPage(searchFilter));
        return responseEntity;
    }
    @RequestMapping(value = "page",method = RequestMethod.GET)
   public Page<Role> getPage(SearchFilter searchFilter){
        logger.debug("测试logback日志!");
        return roleService.queryPage(searchFilter);
    }
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update() {
        String sql = "update t_sys_org set name='66666'";
        roleService.updateBySql(sql);
        return "index";
    }
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public String delete(){
        roleService.delete(1468047179l);
        return null;
    }

}
