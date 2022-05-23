package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.entity.*;
import com.codegym.module4casestudy.service.chat.IChatService;
import com.codegym.module4casestudy.service.chat1.IChat1Service;
import com.codegym.module4casestudy.service.commentPostUser.ICommentPostUserService;
import com.codegym.module4casestudy.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class WebSocketControlller {

    @Autowired
    private IChat1Service chatService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IChatService groupChatService;

    @MessageMapping("/chats")
    @SendTo("/topic/chats")
    public Chat1 chatting(Chat1 chat) {
        long milis = System.currentTimeMillis();
        Date date = new Date();
        chat.setTime(date);
        chatService.save(chat);
        return chat;
    }
}
