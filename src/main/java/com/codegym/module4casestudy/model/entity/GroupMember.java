package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "groupMembers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Group group;

    @ManyToOne
    private UserInfo userInfo;

    private int status;

    public GroupMember(Group group, UserInfo userInfo, int status) {
        this.group = group;
        this.userInfo = userInfo;
        this.status = status;
    }
}
