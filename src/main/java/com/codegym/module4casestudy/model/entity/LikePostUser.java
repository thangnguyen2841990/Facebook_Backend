package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikePostUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean status;

    @ManyToOne
    private PostUser postUser;

    @ManyToOne
    private UserInfo userInfo;

    public LikePostUser(boolean status, PostUser postUser, UserInfo userInfo) {
        this.status = status;
        this.postUser = postUser;
        this.userInfo = userInfo;
    }
}
