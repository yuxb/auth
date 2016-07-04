package com.auth.pojo;

import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yuxb on 16/5/27.
 */
@Entity
@Table(name="T_SYS_USER")
@Data
public class User extends BasePoJo implements Serializable {

    @Column(name="LOGIN_NAME")
    private String loginName;

    @Column(name ="USER_NAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name = "STATUS")
    private int status;//1启用 0 停用

    @Column(name = "TYPE")
    private int type;

    @Column(name="EMAIL")
    private String email;

    @Column(name = "IDCARD")
    private String idCard;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.JOIN)
    @JoinColumn(name = "ORG_ID" ,updatable = false)
    private Organization org;


}
