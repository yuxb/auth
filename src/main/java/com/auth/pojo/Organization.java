package com.auth.pojo;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by yuxb on 16/5/16.
 */
@Data
@Entity
@Table(name = "T_SYS_ORG")
@DynamicInsert
@DynamicUpdate
public class Organization extends BasePoJo implements Serializable {
    @Column(name = "name")
    private String name;
    @Column(name = "SHORT_NAME")
    private String shortName;
    @Column(name = "CODE")
    private String code;
    @Column(name = "REMARK")
    private String remark;
    @Column(name = "TYPE")
    private String type;
    @Transient
    private Set<Organization> children = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "PARENT_ID")
    private Organization parent;
    @Transient
    private Set<User> users = new HashSet<>();


    @Transient
    public void addChild(Organization child) {
        this.children.add(child);
    }

    @Transient
    public boolean removeChild(Organization child) {
        return this.children.remove(child);
    }
}
