package com.codegym.module4casestudy.repository;

import com.codegym.module4casestudy.model.entity.NotificationCheckStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificationCheckStatusRepository extends JpaRepository<NotificationCheckStatus, Long> {
    @Query(value = "select * from notification_check_status where admin_id = ?1 ", nativeQuery = true)
    List<NotificationCheckStatus> listNoti(Long adminId);

}
