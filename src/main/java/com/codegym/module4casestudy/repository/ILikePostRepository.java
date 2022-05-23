package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.LikePostUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ILikePostRepository extends JpaRepository<LikePostUser, Long> {

    @Query(value = "select * from like_post_user where user_info_id = ?1 and post_user_id = ?2 ", nativeQuery = true)
    Optional<LikePostUser> findLikePostUserByUserInfoIdAndPostUserId(Long userInfoId, Long postUserId);

    @Query(value = "select  * from like_post_user where post_user_id = ?1",nativeQuery = true)
        List<LikePostUser> totalLikeByPost(Long postUserId);


}
