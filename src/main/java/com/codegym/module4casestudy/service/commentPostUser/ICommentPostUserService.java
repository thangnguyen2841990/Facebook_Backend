package com.codegym.module4casestudy.service.commentPostUser;


import com.codegym.module4casestudy.model.entity.CommentPostUser;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;

public interface ICommentPostUserService extends IGeneralService<CommentPostUser> {
    List<CommentPostUser> displayAllCommentOfPost(Long postUserId);


}
