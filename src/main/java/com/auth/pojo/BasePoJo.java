package com.auth.pojo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by yuxb on 16/5/16.
 */
@MappedSuperclass
@Data
public class BasePoJo {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "CREATE_TIME")
    private String createTime;
    @Column(name = "CREATE_USER")
    private Long createUser;
    @Column(name = "MODIFY_TIME")
    private String modifyTime;
    @Column(name = "MODIFY_USER")
    private Long modifyUser;



}
