package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.LikeComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILikeCommentRepo extends JpaRepository<LikeComment, Long> {
@Query(value = "select * from like_comment where comment_post_user_id = ?1 and from_user_id = ?2",nativeQuery = true)
    Optional<LikeComment> findLikeCommentByUser(Long cmPostUserId, Long fromUserId);

@Query(value = "select * from like_comment where comment_post_user_id = ?1", nativeQuery = true)
List<LikeComment> listLikeComments(Long cmPostUserId);

}
