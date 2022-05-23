package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.dto.MessagerDTO;
import com.codegym.module4casestudy.model.entity.Chat;
import com.codegym.module4casestudy.model.entity.Chat1;
import com.codegym.module4casestudy.model.entity.User;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.chat.IChatService;
import com.codegym.module4casestudy.service.chat1.IChat1Service;
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
@RequestMapping("/chats")
public class Chat1Controller {
    @Autowired
    private IChat1Service chatService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IChatService groupChatService;
    @Autowired
    private IPostService postService;
    @GetMapping
    public ResponseEntity<List<MessagerDTO>> getAllChat(@RequestParam("userId1") Long userId1,
                                                        @RequestParam("userId2") Long userId2
                                                     ) {
        List<Chat1> listChat = (List<Chat1>) chatService.getAllHistoryBetweenTwoUser(userId1, userId2);
        List<MessagerDTO> chats = new ArrayList<>();
        for (int i = 0; i < listChat.size(); i++) {
            chats.add(new MessagerDTO(listChat.get(i).getId(),
                                        listChat.get(i).getSender(),
                                        listChat.get(i).getReceiver(),
                                        listChat.get(i).getContent(),
                                        listChat.get(i).isStatus(),
                                           postService.getDiffDays(listChat.get(i).getTime(), new Date()) ));
        }
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chat1> createNewChat(@RequestBody Chat1 chat) {
        long milis = System.currentTimeMillis();
        Date date = new Date();
        chat.setTime(date);
        chatService.save(chat);

        return new ResponseEntity<>(chat, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Chat1> getChat(@PathVariable Long id) {
        Optional<Chat1> categoryOptional = chatService.findById(id);
        return categoryOptional.map(chat -> new ResponseEntity<>(chat, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chat1> updateChat(@PathVariable Long id, @RequestBody Chat1 chat) {
        Optional<Chat1> categoryOptional = chatService.findById(id);
        return categoryOptional.map(chat1 -> {
            chat.setId(chat1.getId());
            return new ResponseEntity<>(chatService.save(chat), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id1}/{id2}")
    public ResponseEntity<Chat1> deleteChat(@PathVariable Long id1, @PathVariable Long id2) {
        UserInfo user1 = this.userInfoService.findByUserId(id1).get();
        UserInfo user2 = this.userInfoService.findByUserId(id2).get();
      List<Chat1> listChat = this.chatService.listChatOfMe(user1.getId(), user2.getId());
        for (int i = 0; i < listChat.size(); i++) {
            this.chatService.deleteById(listChat.get(i).getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
