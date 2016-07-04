package com.auth.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static com.sun.tools.corba.se.idl.constExpr.Expression.one;

/**
 * Created by yuxb on 16/5/16.
 */
@Entity
@Table(name = "T_SYS_ORG")
@Setter
@Getter
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

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Organization> children = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PARENT_ID")
    private Organization parent;

    @OneToMany(mappedBy = "org", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> userHashSet = new HashSet<>();


    @Transient
    public void addChild(Organization child) {
        this.children.add(child);
    }

    @Transient
    public boolean removeChild(Organization child) {
        return this.children.remove(child);
    }
}
