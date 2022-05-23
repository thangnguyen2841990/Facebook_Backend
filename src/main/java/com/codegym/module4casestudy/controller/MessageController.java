package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.dto.MessageFrontend;
import com.codegym.module4casestudy.model.entity.Message;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.message.IMessageService;
import com.codegym.module4casestudy.service.post.IPostService;
import com.codegym.module4casestudy.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private IMessageService messageServicel;
    @Autowired
    private IPostService postService;
    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("/{toUserId}")
    public ResponseEntity<List<MessageFrontend>> showAllMessages(@PathVariable Long toUserId){
        UserInfo userInfo = this.userInfoService.findByUserId(toUserId).get();
        List<Message> messages = messageServicel.findAllMessage(userInfo.getId());
        List<MessageFrontend> messages1= new ArrayList<>();
        if (messages.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (int i = 0; i < messages.size(); i++) {
            messages1.add(new MessageFrontend(messages.get(i).getId(),messages.get(i).getFromUser(),messages.get(i).getToUser()
            ,postService.getDiffDays(messages.get(i).getDateCreated(),new Date()),messages.get(i).getContent(),messages.size(),messages.get(i).getStatus()));
        }
        return new ResponseEntity<>(messages1,HttpStatus.OK);
    }
    @GetMapping("/total/{toUserId}")
    public ResponseEntity<Integer> totalMessage(@PathVariable Long toUserId){
        UserInfo toUserInfo  = this.userInfoService.findByUserId(toUserId).get();
        Integer totalMessage  = this.messageServicel.findAllMessage(toUserInfo.getId()).size();
        return new ResponseEntity<>(totalMessage, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteMessage(@PathVariable Long id) {
         this.messageServicel.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @DeleteMapping("/{toUserId}")
//    public ResponseEntity<Message> deleteMessage(@PathVariable Long toUserId){
//        UserInfo toUser = this.userInfoService.findByUserId(toUserId).get();
//        List<Message> listMessage = this.messageServicel.findAllMessage(toUser.getId());
//        Message message = new Message();
//        for (int i = 0; i <listMessage.size(); i++){
//            this.messageServicel.deleteById(listMessage.get(i).getId());
//        }
//        this.messageServicel.deleteMessage(toUser.getId());
//        return new ResponseEntity(message, HttpStatus.OK);
//    }
}
