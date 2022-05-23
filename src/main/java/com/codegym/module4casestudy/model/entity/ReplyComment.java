package com.codegym.module4casestudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Date dateCreated;


    @ManyToOne
    private UserInfo userInfoComment;

    @ManyToOne
    private CommentPostUser comment;

    @ManyToOne
    private PostUser postUser;
}
