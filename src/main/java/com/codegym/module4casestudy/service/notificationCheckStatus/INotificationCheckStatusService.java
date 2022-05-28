package com.codegym.module4casestudy.service.notificationCheckStatus;

import com.codegym.module4casestudy.model.entity.NotificationCheckStatus;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;

public interface INotificationCheckStatusService extends IGeneralService<NotificationCheckStatus> {

    List<NotificationCheckStatus> listNoti(Long adminId);

}
