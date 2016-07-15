package com.auth.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static com.sun.tools.doclets.internal.toolkit.util.DocPath.parent;
import static javafx.scene.input.KeyCode.F;

/**
 * Created by yuxb on 16/5/27.
 */
@Entity
@Table(name="T_SYS_RESOURCE")
@Setter
@Getter
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
    private String type;//资源类型 菜单;按钮;

    @Column(name = "level")
    private Integer level;//资源等级 一级 二级 主要是菜单等级
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PARENT_ID")
    private Resource parent;
    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Resource> children=new HashSet<>();

    @OneToMany(mappedBy = "resource" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<RoleResource> roleResources=new HashSet<>();



    public void addChild(Resource child) {
        this.children.add(child);
    }

    public boolean removeChild(Resource child) {
        return this.children.remove(child);
    }
}
