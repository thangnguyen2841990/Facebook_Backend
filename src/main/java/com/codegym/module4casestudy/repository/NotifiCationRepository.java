package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.NotificationAddFriends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotifiCationRepository extends JpaRepository<NotificationAddFriends, Long> {
    @Query(value = "select * from notification_add_friends where to_user_id = ?1",nativeQuery = true)
    List<NotificationAddFriends>  showNotifications(Long toUserId);

    @Query(value = "select * from notification_add_friends where from_user_id = ?1",nativeQuery = true)
    List<NotificationAddFriends>  showAllSendNotifications(Long fromUserId);


    @Query(value = "select * from notification_add_friends where from_user_id = ?1 and status = 1", nativeQuery = true)
    List<NotificationAddFriends> listFriends(Long fromUserId);

    @Query(value = "delete from notification_add_friends where status = 2",nativeQuery = true)
    void deleteNotification();

    @Query(value = "select * from notification_add_friends where from_user_id = ?1 and to_user_id = ?2", nativeQuery = true)
    Optional<NotificationAddFriends> findNotificationAddFriends(Long fromUserId, Long toUserId);
}
