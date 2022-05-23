package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.ReplyComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReplyCommentRepository extends JpaRepository<ReplyComment, Long> {
    @Query(value = "select * from reply_comment where post_user_id = ?1 order by date_created desc", nativeQuery = true)
    List<ReplyComment>  getAllReplyOfComment(Long postId);
    @Query(value = "select * from reply_comment where comment_id = ?1", nativeQuery = true)
    List<ReplyComment>  getAllRepLy(Long commentId);

}
