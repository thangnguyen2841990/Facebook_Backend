package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListFriend {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserInfo userInfo;

    @ManyToOne
    private UserInfo friendsOfUserinfo;

    public ListFriend(UserInfo userInfo, UserInfo friendsOfUserinfo) {
        this.userInfo = userInfo;
        this.friendsOfUserinfo = friendsOfUserinfo;
    }
}
