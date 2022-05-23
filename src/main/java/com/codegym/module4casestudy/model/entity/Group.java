package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table( name = "groups_")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String avatar;
    private String background;
    @ManyToOne
    private UserInfo user;
    @ManyToOne
    private GroupStatus groupStatus;

    public Group(String name, GroupStatus groupStatus) {
        this.name = name;
        this.groupStatus = groupStatus;
    }

    public Group(String name, String avatar, String background, UserInfo user, GroupStatus groupStatus) {
        this.name = name;
        this.avatar = avatar;
        this.background = background;
        this.user = user;
        this.groupStatus = groupStatus;
    }
}
