package com.auth.pojo;

import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static com.sun.tools.doclets.internal.toolkit.util.DocPath.parent;

/**
 * Created by yuxb on 16/5/27.
 */
@Entity
@Table(name="T_SYS_RESOURCE")
@Data
public class Resource extends BasePoJo implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "icon")
    private String icons;

    @Column(name = "short_name")
    private String shortName;

    @Column(name="RESOURCE_KEY")
    private String key;

    @Column(name = "comments")
    private String comments;

    @Column(name = "type")
    private String type;//资源类型 菜单;按钮;超链接

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PARENT_ID")
    private Resource parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Resource> children=new HashSet<>();
    @ManyToMany
    @JoinTable(name = "t_sys_role_resource",inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @JoinColumns(value = @JoinColumn(name = "Resource_id"))
    private Set<Role> roleSet=new HashSet<>();

    @Transient
    public void addChild(Resource child) {
        this.children.add(child);
    }

    @Transient
    public boolean removeChild(Resource child) {
        return this.children.remove(child);
    }
}
