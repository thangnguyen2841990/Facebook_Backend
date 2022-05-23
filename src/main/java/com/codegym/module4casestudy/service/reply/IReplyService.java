package com.codegym.module4casestudy.service.reply;

import com.codegym.module4casestudy.model.entity.ReplyComment;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;

public interface IReplyService extends IGeneralService<ReplyComment> {

    List<ReplyComment> getAllReplyOfComment(Long postId);

    List<ReplyComment>  getAllRepLy(Long commentId);


}
