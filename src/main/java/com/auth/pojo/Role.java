package com.auth.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static com.sun.tools.internal.xjc.reader.Ring.add;
import static com.sun.tools.internal.xjc.reader.Ring.get;
import static javafx.scene.input.KeyCode.F;
import static javafx.scene.input.KeyCode.R;

/**
 * Created by yuxb on 6/24/16.
 */
@Setter
@Getter
@Entity
@Table(name = "t_sys_Role")
public class Role extends BasePoJo implements Serializable {
    @Column(name = "NAME")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "role" ,targetEntity = RoleResource.class,cascade = CascadeType.PERSIST)
    private Set<RoleResource> roleResources=new HashSet<>();

}
