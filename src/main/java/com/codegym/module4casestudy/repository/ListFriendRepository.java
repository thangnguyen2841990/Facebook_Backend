package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.ListFriend;
import com.codegym.module4casestudy.model.entity.NotificationAddFriends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListFriendRepository extends JpaRepository<ListFriend, Long>  {
@Query(value = "select * from list_friend where user_info_id = ?1 ",nativeQuery = true)
    public List<ListFriend> showAllFriends(Long userInfoId);

    @Query(value = "select * from list_friend where user_info_id = ?1 and friends_of_userinfo_id = ?2", nativeQuery = true)
    Optional<ListFriend> findFriends(Long fromUserId, Long toUserId);

    @Query(value = "select friends_of_userinfo_id from list_friend where user_info_id = ?1 and friends_of_userinfo_id not in (select user_info_id from group_members where group_id = ?2 )", nativeQuery = true)
    List<ListFriend> listUserAdd(Long userID, Long groupId);

}
