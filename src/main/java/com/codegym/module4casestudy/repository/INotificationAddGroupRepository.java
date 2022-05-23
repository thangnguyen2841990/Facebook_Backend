package com.codegym.module4casestudy.repository;


import com.codegym.module4casestudy.model.entity.NotificationAddGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface INotificationAddGroupRepository extends JpaRepository<NotificationAddGroup, Long> {
    @Query(value = "select * from notification_add_groups where to_user_id = ?1", nativeQuery = true)
    List<NotificationAddGroup> showNotificationAddGroup(Long toUserId);

    @Query(value = "select * from notification_add_groups where from_user_id = ?1", nativeQuery = true)
    List<NotificationAddGroup> showNotificationAddGroupForm(Long formUserId);

    @Query(value = "select * from notification_add_groups where group_id =?1 and from_user_id = ?2", nativeQuery = true)
    Optional<NotificationAddGroup> findNotification(Long groupId, Long fromId);

    @Query(value = "select * from notification_add_groups where from_user_id =?1 and group_id =?2 and to_user_id =?3 and status = 1", nativeQuery = true)
    Optional<NotificationAddGroup> findNotificationByGroupIdAndFromUserId(Long fromUserId, Long groupId, Long toUserID);

    @Query(value = "select * from notification_add_groups where to_user_id = ?1 and status = 1", nativeQuery = true)
    List<NotificationAddGroup> showNotificationAddGroup1(Long toUserId);

    @Query(value = "select * from notification_add_groups where from_user_id = ?1 and status = 0", nativeQuery = true)
    List<NotificationAddGroup> showNotificationAddGroupForm11(Long formUserId);
    @Query(value = "select * from notification_add_groups where group_id = ?1 and status = 1", nativeQuery = true)
    List<NotificationAddGroup> showNotificationAddGroupForm2(Long groupId);
}