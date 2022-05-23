package com.codegym.module4casestudy.model.dto;

import com.codegym.module4casestudy.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostUserFrontEnd {
    private Long postUserId;

    private String content;

    private ImagePostUser[] listImage;

    private String dateCreated;

    private UserInfo userInfo;

    private Integer totalLike;

    private List<CommentPostUser> comments;

    private int totalComments;

    private StatusPost status;

    private List<TotalLikeCm> totalLikeCm;

    private List<ReplyComment> listReply;

    private int totalReply;



    public PostUserFrontEnd(Long postUserId, String content, ImagePostUser[] listImage, String dateCreated, UserInfo userInfo, StatusPost status) {
        this.postUserId = postUserId;
        this.content = content;
        this.listImage = listImage;
        this.dateCreated = dateCreated;
        this.userInfo = userInfo;
        this.status = status;
    }
}
