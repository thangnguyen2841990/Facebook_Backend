package com.codegym.module4casestudy.service.notifiationAddGroup;


import com.codegym.module4casestudy.model.entity.NotificationAddFriends;
import com.codegym.module4casestudy.model.entity.NotificationAddGroup;
import com.codegym.module4casestudy.service.IGeneralService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface INotificationGroupService extends IGeneralService<NotificationAddGroup> {
    List<NotificationAddGroup> showNotificationAddGroup(Long toUserId);
    List<NotificationAddGroup> showNotificationAddGroupForm(Long formUserId);

    Optional<NotificationAddGroup> findNotification(Long groupId, Long fromId);
    Optional<NotificationAddGroup> findNotificationByGroupIdAndFromUserId(Long fromUserId, Long groupId, Long toUserId);
    List<NotificationAddGroup> showNotificationAddGroup1(Long toUserId);
    List<NotificationAddGroup> showNotificationAddGroupForm11(Long formUserId);
    List<NotificationAddGroup> showNotificationAddGroupForm2(Long groupId);


}
