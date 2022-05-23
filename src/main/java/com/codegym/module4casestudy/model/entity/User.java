package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private Boolean blockStatus;

    private Date createDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role")
    private List<Role> roles;


    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(String username, String password, Boolean blockStatus, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.blockStatus = blockStatus;
        this.roles = roles;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
