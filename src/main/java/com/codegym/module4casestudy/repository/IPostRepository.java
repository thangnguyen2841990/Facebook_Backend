package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.dto.UserDetails;
import com.codegym.module4casestudy.model.entity.PostUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface IPostRepository extends JpaRepository<PostUser, Long> {
    @Modifying
    @Query(value = "call deletePost(?1)", nativeQuery = true)
    void deletePost(Long postUserId);

    @Query(value = "select * from post_user where user_info_id = ?1 order by date_created desc", nativeQuery = true)
    List<PostUser> showAllPostByUser(Long userInfoId);

    @Query(value = "select * from post_user join user_info on post_user.user_info_id = user_info.id =?1 ", nativeQuery = true)
    UserDetails findUserDetails(Long userId);

    @Query(value = "select * from post_user where user_info_id in (select friends_of_userinfo_id from list_friend where user_info_id =?1 ) and status_id in (1,2)  order by date_created desc", nativeQuery = true)
    List<PostUser> postUserFriends(Long userId);


}
