package com.auth.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yuxb on 16/7/7.
 */
@Setter
@Getter
@Entity
@Table(name = "T_SYS_ROLE_USER")
public class RoleUser implements Serializable {
    @Id
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
