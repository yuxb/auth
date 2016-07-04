package com.auth.controller;
/**
 * Created by yuxb on 16/5/16.
 */

import com.auth.pojo.Organization;
import com.auth.service.OrgService;
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

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *机构控制类
 *
 */
@Data
@Controller
@RequestMapping(value = "/org")

public class OrgController {
    @Autowired
    private OrgService orgService;

    Logger logger= LoggerFactory.getLogger(OrgController.class);
    /**
     *新增机构
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Organization org) {
        org.setId(App.generateId());
        orgService.save(org);
        return "index";
    }

    @Cacheable(value="userList")
    @ResponseBody
    @RequestMapping(value="list",method = RequestMethod.GET)
    public ResponseEntity  getList(SearchFilter searchFilter){
        ResponseEntity responseEntity =new ResponseEntity<List<Organization>>();
        responseEntity.setCode("200");
        responseEntity.setInfo("操作成功");
        responseEntity.setData(orgService.queryPage(searchFilter));
        return responseEntity;
    }
    @RequestMapping(value = "page",method = RequestMethod.GET)
   public Page<Organization> getPage(SearchFilter searchFilter){
        logger.debug("测试logback日志!");
        return this.orgService.queryPage(searchFilter);
    }
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update() {
        String sql = "update t_sys_org set name='66666'";
        orgService.updateBySql(sql);
        return "index";
    }


}
