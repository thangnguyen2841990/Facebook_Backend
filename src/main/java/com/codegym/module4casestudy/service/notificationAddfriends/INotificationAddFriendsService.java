package com.codegym.module4casestudy.service.notificationAddfriends;

import com.codegym.module4casestudy.model.entity.NotificationAddFriends;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface INotificationAddFriendsService extends IGeneralService<NotificationAddFriends> {
    List<NotificationAddFriends> showNotifications(Long toUserId);

    Optional<NotificationAddFriends> findNotificationAddFriends(Long fromUserId, Long toUserId);
    List<NotificationAddFriends>  showAllSendNotifications(Long fromUserId);


}
