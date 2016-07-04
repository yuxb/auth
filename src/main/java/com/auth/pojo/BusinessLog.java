package com.auth.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by yuxb on 16/7/1.
 */
@Data
@Entity
@Table(name = "T_SYS_BUSINESS_LOG")
public class BusinessLog extends BasePoJo implements Serializable{

    @Column(name = "type")
    private String type;

    @Column(name = "content")
    private String content;

    @Column(name = "app_key")
    private String appKey;

    @Column(name = "remark")
    private String remark;

    @Column(name = "url")
    private String url;

    @Column(name = "level")
    private String level;
}
