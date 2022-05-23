package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.entity.CommentPostUser;
import com.codegym.module4casestudy.model.entity.PostUser;
import com.codegym.module4casestudy.model.entity.ReplyComment;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.commentPostUser.ICommentPostUserService;
import com.codegym.module4casestudy.service.post.IPostService;
import com.codegym.module4casestudy.service.reply.IReplyService;
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
@RequestMapping("/comments")
public class CommentPostUserController {
        @Autowired
        private ICommentPostUserService commentPostUserService;
        @Autowired
        private IUserInfoService userInfoService;
        @Autowired
        private IPostService postService;
        @Autowired
        private IReplyService replyService;
        @PostMapping
        public ResponseEntity<CommentPostUser> createComments(@RequestBody CommentPostUser comment) {
                long milis = System.currentTimeMillis();
                Date date = new Date(milis);
                comment.setDateCreated(date);
                return new ResponseEntity<>(commentPostUserService.save(comment), HttpStatus.OK);
        }

        @PostMapping("/{userId}/{postUserId}")
        public ResponseEntity<CommentPostUser> createNewComment(@PathVariable Long userId, @PathVariable Long postUserId, @RequestBody CommentPostUser commentPostUser){
                UserInfo userInfo = this.userInfoService.findByUserId(userId).get();
                PostUser postUser = this.postService.findById(postUserId).get();
                String content = commentPostUser.getContent();
                CommentPostUser newComment = this.commentPostUserService.save(new CommentPostUser(content,new Date(),userInfo,postUser));
                return new ResponseEntity<>(newComment, HttpStatus.OK);
        }
        @PutMapping("/{id}")
        public ResponseEntity<CommentPostUser> editComment(@PathVariable Long id,  @RequestBody CommentPostUser commentPostUser) {
                Optional<CommentPostUser> comment = this.commentPostUserService.findById(id);
                if (!comment.isPresent()){
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                CommentPostUser newComment = comment.get();
                newComment.setId(id);
                newComment.setContent(commentPostUser.getContent());
                this.commentPostUserService.save(newComment);
                return new ResponseEntity<>(newComment, HttpStatus.OK);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<CommentPostUser> deleteComment(@PathVariable Long id) {
                Optional<CommentPostUser> comment = this.commentPostUserService.findById(id);
                if (!comment.isPresent()){
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                List<ReplyComment> listReply = this.replyService.getAllRepLy(comment.get().getId());
                for (int i = 0; i < listReply.size(); i++) {
                        this.replyService.deleteById(listReply.get(i).getId());
                }
                this.commentPostUserService.deleteById(comment.get().getId());

                return new ResponseEntity<>(HttpStatus.OK);
        }
        @GetMapping("/{userId}")
        public ResponseEntity<List<CommentPostUser>> displayAllCommentOfPost(@PathVariable Long userId){
                Optional<UserInfo> userInfo = this.userInfoService.findByUserId(userId);
                List<PostUser> postUsers = this.postService.showAllPostByUser(userInfo.get().getId());
                List<CommentPostUser> comments = new ArrayList();
                for (int i = 0; i < postUsers.size(); i++) {
                        comments = this.commentPostUserService.displayAllCommentOfPost(postUsers.get(i).getId());
                }
        return new ResponseEntity<>(comments, HttpStatus.OK);
        }
        @GetMapping("/comment/{commentId}")
        public ResponseEntity<CommentPostUser> findById(@PathVariable Long commentId) {
                Optional<CommentPostUser> commentOptinal = this.commentPostUserService.findById(commentId);
                if (!commentOptinal.isPresent()) {
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                this.commentPostUserService.findById(commentId);
                return new ResponseEntity<>(commentOptinal.get() ,HttpStatus.OK);
        }
}
