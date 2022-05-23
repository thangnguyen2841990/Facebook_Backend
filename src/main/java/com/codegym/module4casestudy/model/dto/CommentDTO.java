package com.codegym.module4casestudy.model.dto;

import com.codegym.module4casestudy.model.entity.PostUser;
import com.codegym.module4casestudy.model.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long id;

    private String content;

    private String dateCreated;

    private UserInfo userInfoPost;

    private PostUser postUser;
}
