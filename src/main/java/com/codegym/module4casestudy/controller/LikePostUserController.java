package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.entity.*;
import com.codegym.module4casestudy.service.likePostUser.ILikePostUserService;
import com.codegym.module4casestudy.service.message.IMessageService;
import com.codegym.module4casestudy.service.post.IPostService;
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
@RequestMapping("/likePosts")
public class LikePostUserController {
    @Autowired
    private ILikePostUserService likePostUserService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IPostService postService;
    @Autowired
    private IMessageService messageService;

   @PostMapping("/{userId}/{postUserId}")
    public ResponseEntity<LikePostUser> createNewLikePost(@PathVariable Long userId, @PathVariable Long postUserId){
        UserInfo userInfo = this.userInfoService.findByUserId(userId).get();
        PostUser postUser = this.postService.findById(postUserId).get();
        UserInfo toUser = postUser.getUserInfo();
        Optional<LikePostUser> like = this.likePostUserService.findLikePostUserByUserInfoIdAndPostUserId(userInfo.getId(),postUserId);
        if (!like.isPresent()){
            LikePostUser likePostUser = new LikePostUser(true,postUser,userInfo);
            this.likePostUserService.save(likePostUser);

            Message newMessage = new Message();
            newMessage.setFromUser(userInfo);
            newMessage.setToUser(toUser);
            Date date = new Date();
            newMessage.setDateCreated(date);
            newMessage.setContent("Thích bài viết của bạn!");
            newMessage.setStatus(2);
            this.messageService.save(newMessage);
            return new ResponseEntity<>(likePostUser,HttpStatus.OK);

        }else{
            this.likePostUserService.deleteById(like.get().getId());
            return new ResponseEntity<>(like.get(),HttpStatus.OK);
        }
   }
   @GetMapping("/{postUserId}")
    public ResponseEntity<Integer> countLikeOfPost(@PathVariable Long postUserId){
       List<LikePostUser> likes = this.likePostUserService.totalLikeByPost(postUserId);
       Integer totalLikeByPost = likes.size();
       return new ResponseEntity<Integer>(totalLikeByPost,HttpStatus.OK);
   }
}
