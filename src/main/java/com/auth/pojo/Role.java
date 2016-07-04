package com.auth.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuxb on 6/24/16.
 */
@Data
@Entity
@Table(name = "t_sys_Role")
public class Role extends BasePoJo implements Serializable {
    @Column(name = "NAME")
    private String name;
    @Column(name = "type")
    private String type;
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "T_SYS_ROLE_RESOURCE",inverseJoinColumns = @JoinColumn(name = "RESOURCE_ID"))
    @JoinColumns(value =@JoinColumn(name = "ROLE_ID"))

    Set<Resource> resourceSet = new HashSet<>();
}
