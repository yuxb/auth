package com.auth.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yuxb on 16/7/12.
 */
@Setter
@Getter
@Entity
@Table(name = "T_SYS_ROLE_RESOURCE")
public class RoleResource implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ROLE_ID" )
    private Role role;
    @ManyToOne
    @JoinColumn(name = "RESOURCE_ID" )
    private Resource resource;
}
