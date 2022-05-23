package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserInfo fromUser;

    @ManyToOne
    private CommentPostUser commentPostUser;

    private int status;

    public LikeComment(UserInfo fromUser, CommentPostUser commentPostUser, int status) {
        this.fromUser = fromUser;
        this.commentPostUser = commentPostUser;
        this.status = status;
    }
}
