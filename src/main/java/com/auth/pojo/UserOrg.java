package com.auth.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yuxb on 6/23/16.
 * 用户机构关联表
 */
@Entity
@Data
@Table(name = "T_SYS_USER_ORG")
public class UserOrg {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "ORG_ID")
    private Long OrgId;
}
