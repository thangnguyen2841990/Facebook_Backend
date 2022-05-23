package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.entity.CommentPostUser;
import com.codegym.module4casestudy.model.entity.LikeComment;
import com.codegym.module4casestudy.model.entity.Message;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.commentPostUser.ICommentPostUserService;
import com.codegym.module4casestudy.service.likePostUser.ILikePostUserService;
import com.codegym.module4casestudy.service.likecomment.ILikeCommentService;
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
@RequestMapping("/likeComments")
public class LikeCommentController {
    @Autowired
    private ILikePostUserService likePostUserService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IPostService postService;
    @Autowired
    private IMessageService messageService;
    @Autowired
    private ILikeCommentService likeCommentService;
    @Autowired
    private ICommentPostUserService commentPostUserService;

    @PostMapping("/{commentId}/{userId}")
    public ResponseEntity<LikeComment> createLikeComment(@PathVariable Long commentId, @PathVariable Long userId){
        UserInfo fromUser = this.userInfoService.findByUserId(userId).get();
        CommentPostUser commentPostUser = this.commentPostUserService.findById(commentId).get();
        Optional<LikeComment> likeComment = this.likeCommentService.findLikeCommentByUser(commentId,fromUser.getId());
        UserInfo toUser = commentPostUser.getUserInfoPost();
        if (!likeComment.isPresent()) {
            LikeComment newLikeComment = new LikeComment(fromUser,commentPostUser,0);
            this.likeCommentService.save(newLikeComment);

            Message newMessage = new Message();
            newMessage.setFromUser(fromUser);
            newMessage.setToUser(toUser);
            Date date = new Date();
            newMessage.setDateCreated(date);
            newMessage.setContent("Thích bình luận của bạn!");
            newMessage.setStatus(4);
            this.messageService.save(newMessage);
            return new ResponseEntity<>(newLikeComment, HttpStatus.OK);
        }else{
            this.likeCommentService.deleteById(likeComment.get().getId());
            return new ResponseEntity<>(likeComment.get(),HttpStatus.OK);
        }
    }
    @GetMapping("/{cmPostId}")
    public ResponseEntity<Integer> totalLikeCm(@PathVariable Long cmPostId){
        CommentPostUser commentPostUser = this.commentPostUserService.findById(cmPostId).get();
        List<LikeComment> listLikeComments = this.likeCommentService.listLikeComments(cmPostId);
        return new ResponseEntity<>(listLikeComments.size(), HttpStatus.OK);
    }
}
