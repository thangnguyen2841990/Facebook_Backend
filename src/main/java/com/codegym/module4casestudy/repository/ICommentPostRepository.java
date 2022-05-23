package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.CommentPostUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentPostRepository extends JpaRepository<CommentPostUser, Long> {

    @Query(value = "select * from comment_post_user where post_user_id = ?1 order by date_created desc ", nativeQuery = true)
    List<CommentPostUser> displayAllCommentOfPost(Long postUserId);




}
