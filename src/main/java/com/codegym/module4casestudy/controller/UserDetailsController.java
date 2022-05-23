package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.dto.*;
import com.codegym.module4casestudy.model.entity.CommentPostUser;
import com.codegym.module4casestudy.model.entity.PostUser;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.commentPostUser.ICommentPostUserService;
import com.codegym.module4casestudy.service.imagePostUser.IImagePostUserService;
import com.codegym.module4casestudy.service.likePostUser.ILikePostUserService;
import com.codegym.module4casestudy.service.likecomment.ILikeCommentService;
import com.codegym.module4casestudy.service.post.IPostService;
import com.codegym.module4casestudy.service.reply.IReplyService;
import com.codegym.module4casestudy.service.user.IUserService;
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
@RequestMapping("/userDetails")
public class UserDetailsController {
    @Autowired
    private IPostService postService;
    @Autowired
    private IImagePostUserService imagePostUser;

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IImagePostUserService imagePostUserService;

    @Autowired
    private ILikePostUserService likePostUserService;

    @Autowired
    private ICommentPostUserService commentPostUserService;
    @Autowired
    private ILikeCommentService likeCommentService;
    @Autowired
    private IReplyService replyService;

    @GetMapping("/{userInfoId}")
    public ResponseEntity<UserDetails> showAllPostUser(@PathVariable Long userInfoId) {
        Optional<UserInfo> userInfo = this.userInfoService.findById(userInfoId);
        List<PostUser> postUsers = this.postService.showAllPostByUser(userInfo.get().getId());
        List<PostUserFrontEnd> postUserFrontEnd = new ArrayList<>();
        List<CommentDTO> comments = new ArrayList<>();
        List<TotalLikeCm> totalLikeCm = new ArrayList<>();
        List<ListReply> listReply = new ArrayList<>();


        for (int i = 0; i < postUsers.size(); i++) {
            List<CommentPostUser> listCm = this.commentPostUserService.displayAllCommentOfPost(postUsers.get(i).getId());
            for (int j = 0; j < listCm.size(); j++) {
                totalLikeCm.add(new TotalLikeCm(listCm.get(j).getId()
                        , this.likeCommentService.listLikeComments(listCm.get(j).getId()).size()));
            }
            for (int j = 0; j < listCm.size(); j++) {
                comments.add(new CommentDTO(listCm.get(j).getId(),
                        listCm.get(j).getContent(),
                        this.postService.getDiffDays(listCm.get(j).getDateCreated(), new Date()),
                        listCm.get(j).getUserInfoPost(),
                        listCm.get(j).getPostUser()));
            }
            postUserFrontEnd.add(new PostUserFrontEnd(postUsers.get(i).getId(), postUsers.get(i).getContent(), imagePostUserService.listImage(postUsers.get(i).getId()),
                    this.postService.getDiffDays(postUsers.get(i).getDateCreated(), new Date())
                    , postUsers.get(i).getUserInfo(), likePostUserService.totalLikeByPost(postUsers.get(i).getId()).size(),
                    this.commentPostUserService.displayAllCommentOfPost(postUsers.get(i).getId()),
                    commentPostUserService.displayAllCommentOfPost(postUsers.get(i).getId()).size(),
                    postUsers.get(i).getStatus(),
                    totalLikeCm,
                    this.replyService.getAllReplyOfComment(postUsers.get(i).getId()),
                    this.replyService.getAllReplyOfComment(postUsers.get(i).getId()).size()
            ));
        }
        UserDetails userDetails = new UserDetails(userInfo.get(), postUserFrontEnd);
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
}
