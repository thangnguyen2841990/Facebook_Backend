package com.codegym.module4casestudy.service.likePostUser;

import com.codegym.module4casestudy.model.entity.LikePostUser;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface ILikePostUserService  extends IGeneralService<LikePostUser> {
    List<LikePostUser> findAll();

    Optional<LikePostUser> findLikePostUserByUserInfoIdAndPostUserId(Long userInfoId, Long postUserId);

    List<LikePostUser> totalLikeByPost(Long postUserId);

}
