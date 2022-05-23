package com.codegym.module4casestudy.service.likecomment;

import com.codegym.module4casestudy.model.entity.LikeComment;
import com.codegym.module4casestudy.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ILikeCommentService extends IGeneralService<LikeComment> {
    Optional<LikeComment> findLikeCommentByUser(Long cmPostUserId, Long fromUserId);
    List<LikeComment> listLikeComments(Long cmPostUserId);

}
