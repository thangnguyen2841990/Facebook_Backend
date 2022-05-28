package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.entity.NotificationCheckStatus;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.notificationCheckStatus.INotificationCheckStatusService;
import com.codegym.module4casestudy.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/checkStatus")
public class NotificationCheckStatusController {
    @Autowired
    private INotificationCheckStatusService notificationCheckStatusService;
    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("/{adminId}")
    public ResponseEntity<List<NotificationCheckStatus>>  listNotification(@PathVariable Long adminId) {
        UserInfo userInfo = this.userInfoService.findByUserId(adminId).get();
        List<NotificationCheckStatus> listNoti = this.notificationCheckStatusService.listNoti(userInfo.getId());
        return new ResponseEntity<>(listNoti, HttpStatus.OK);
    }
}
