package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.entity.ListFriend;
import com.codegym.module4casestudy.model.entity.Message;
import com.codegym.module4casestudy.model.entity.NotificationAddFriends;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.listFriend.IListFriendService;
import com.codegym.module4casestudy.service.message.IMessageService;
import com.codegym.module4casestudy.service.notificationAddfriends.INotificationAddFriendsService;
import com.codegym.module4casestudy.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/addFriends")
public class NotificationAddFriendsController {
    @Autowired
    private INotificationAddFriendsService notificationAddfriendsService;

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IListFriendService listFriendService;

    @Autowired
    private IMessageService messageService;

    @PostMapping("/{fromUserId}/{toUserId}")
    public ResponseEntity<NotificationAddFriends> createNewNotificationAddFriends(@PathVariable Long fromUserId, @PathVariable Long toUserId){
        Optional<UserInfo> fromUserInfo = this.userInfoService.findByUserId(fromUserId);
        Optional<UserInfo> toUserInfo = this.userInfoService.findById(toUserId);
        Optional<NotificationAddFriends> notificationAddfriends = this.notificationAddfriendsService.findNotificationAddFriends(fromUserInfo.get().getId(),toUserId);
        NotificationAddFriends notificationFriend = new NotificationAddFriends();
        Message newMessage = new Message();
        newMessage.setFromUser(fromUserInfo.get());
        newMessage.setToUser(toUserInfo.get());
        Date date = new Date();
        newMessage.setDateCreated(date);
        newMessage.setContent("Gửi yêu cầu kết bạn!");
        newMessage.setStatus(0);
        this.messageService.save(newMessage);

        if (!notificationAddfriends.isPresent()){
            notificationFriend.setFromUser(fromUserInfo.get());
            notificationFriend.setToUser(toUserInfo.get());
            notificationFriend.setStatus(0);
            notificationAddfriendsService.save(notificationFriend);
            return new ResponseEntity<>(notificationFriend, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/add/{fromUserId}/{toUserId}")
    public ResponseEntity<NotificationAddFriends> acceptFriend(@PathVariable Long fromUserId, @PathVariable Long toUserId){
        UserInfo toUser = this.userInfoService.findByUserId(toUserId).get();
        Optional<NotificationAddFriends> notificationFriend = this.notificationAddfriendsService.findNotificationAddFriends(fromUserId, toUser.getId());
        if (!notificationFriend.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        notificationFriend.get().setStatus(1);
        ListFriend listFriend = new ListFriend(notificationFriend.get().getFromUser(), notificationFriend.get().getToUser());
        ListFriend listFriend1 = new ListFriend(notificationFriend.get().getToUser(), notificationFriend.get().getFromUser());
        listFriendService.save(listFriend);
        listFriendService.save(listFriend1);
        notificationAddfriendsService.deleteById(notificationFriend.get().getId());
        return new ResponseEntity<>(notificationFriend.get(),HttpStatus.OK);
    }
    @GetMapping("/{toUserId}")
    public ResponseEntity<List<ListFriend>> showAllFriends(@PathVariable Long toUserId ){
        UserInfo userInfo = this.userInfoService.findByUserId(toUserId).get();
        List<ListFriend> listFriends = this.listFriendService.findAll(userInfo.getId());
        if (listFriends.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listFriends,HttpStatus.OK);
    }
    @GetMapping("showNotification/{toUserId}")
    public ResponseEntity<List<NotificationAddFriends>> showAllNotificationOfToUSerId(@PathVariable Long toUserId){
        UserInfo toUserInfo = this.userInfoService.findByUserId(toUserId).get();
        List<NotificationAddFriends> listNotifications = this.notificationAddfriendsService.showNotifications(toUserInfo.getId());
        return new ResponseEntity<>(listNotifications,HttpStatus.OK);
    }
    @DeleteMapping("delete/{fromUserId}/{toUserId}")
    public ResponseEntity<ListFriend> deleteFriend(@PathVariable Long fromUserId, @PathVariable Long toUserId){
        UserInfo userInfo = this.userInfoService.findByUserId(fromUserId).get();
        Optional<ListFriend> friend = this.listFriendService.findFriends(userInfo.getId(),toUserId);
        this.listFriendService.deleteById(friend.get().getId());
        return new ResponseEntity<>(friend.get(),HttpStatus.NO_CONTENT);
    }
    @GetMapping("showAllSendNotification/{fromUserId}")
    public ResponseEntity<List<NotificationAddFriends>> showAllSendNotificationOfFromUserId(@PathVariable Long fromUserId){
        UserInfo fromUserInfo = this.userInfoService.findByUserId(fromUserId).get();
        List<NotificationAddFriends> listNotifications = this.notificationAddfriendsService.showAllSendNotifications(fromUserInfo.getId());
        return new ResponseEntity<>(listNotifications,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<NotificationAddFriends> deleteAddFriend(@PathVariable Long id) {
        this.notificationAddfriendsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/cancle/{fromId}/{toId}")
    public ResponseEntity<NotificationAddFriends> cancleAddFriend(@PathVariable Long fromId, @PathVariable Long toId ) {
        UserInfo fromUser = this.userInfoService.findByUserId(fromId).get();
        Optional<NotificationAddFriends> notificationAddFriends = this.notificationAddfriendsService.findNotificationAddFriends(fromUser.getId(), toId);
        this.notificationAddfriendsService.deleteById(notificationAddFriends.get().getId());
        return new ResponseEntity<>(notificationAddFriends.get(),HttpStatus.OK);
    }

}
