package com.codegym.module4casestudy.model.dto;

import com.codegym.module4casestudy.model.entity.CommentPostUser;
import com.codegym.module4casestudy.model.entity.PostUser;
import com.codegym.module4casestudy.model.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Long id;

    private String content;

    private String dateCreated;

    private int totalReply;

    private UserInfo userInfoComment;

    private CommentPostUser comment;

    private PostUser postUser;
}
