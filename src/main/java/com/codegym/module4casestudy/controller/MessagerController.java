package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.dto.ChatDTO;
import com.codegym.module4casestudy.model.dto.MessagerDTO;
import com.codegym.module4casestudy.model.dto.MessagerForm;
import com.codegym.module4casestudy.model.entity.Chat;
import com.codegym.module4casestudy.model.entity.Chat1;
import com.codegym.module4casestudy.model.entity.Messager;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.chat.IChatService;
import com.codegym.module4casestudy.service.message.IMessageService;
import com.codegym.module4casestudy.service.messager.IMessagerService;
import com.codegym.module4casestudy.service.post.IPostService;
import com.codegym.module4casestudy.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/messager")
public class MessagerController {
    @Autowired
    private IMessagerService messageService;

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IPostService postService;

    @Autowired
    private IMessageService messageService1;

    @Autowired
    private IChatService chatService;
    @PostMapping("/{formId}/{toId}")
        public ResponseEntity<Messager> createMessage(@PathVariable Long formId, @PathVariable Long toId, @RequestBody MessagerForm messagerForm) {
        UserInfo formUser = this.userInfoService.findByUserId(formId).get();
        UserInfo toUser = this.userInfoService.findByUserId(toId).get();
        Optional<Chat> chatOptional = this.chatService.findChat(formUser.getId(), toUser.getId());
        Chat chat = new Chat();
        Messager messager = new Messager();
        if (!chatOptional.isPresent()) {
            chat.setUser1(formUser);
            chat.setUser2(toUser);
            chat.setLastContent(messagerForm.getContent());
            chat.setDateCreated(new Date());
            chatService.save(chat);
            messager.setChat(chat);

        } else {
            Chat oldChat = chatOptional.get();
            oldChat.setId(oldChat.getId());
            oldChat.setLastContent(messagerForm.getContent());
            oldChat.setDateCreated(new Date());
            chatService.save(oldChat);
        }
        messager.setFromUser(formUser);
        messager.setToUser(toUser);
        messager.setContent(messagerForm.getContent());
        messager.setDateCreated(new Date());
        this.messageService.save(messager);
        return new ResponseEntity<>(messager, HttpStatus.OK);
        }
    }

