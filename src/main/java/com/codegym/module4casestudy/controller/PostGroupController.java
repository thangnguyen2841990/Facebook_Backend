package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.dto.PostGroupFrontEnd;
import com.codegym.module4casestudy.model.dto.PostUserForm;
import com.codegym.module4casestudy.model.dto.PostUserFrontEnd;
import com.codegym.module4casestudy.model.entity.*;
import com.codegym.module4casestudy.service.group.IGroupService;
import com.codegym.module4casestudy.service.imagePostGroup.IImagePostGroupService;
import com.codegym.module4casestudy.service.message.IMessageService;
import com.codegym.module4casestudy.service.notificationCheckStatus.INotificationCheckStatusService;
import com.codegym.module4casestudy.service.post.IPostService;
import com.codegym.module4casestudy.service.postGroup.IPostGroupService;
import com.codegym.module4casestudy.service.userInfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/postGroups")
public class PostGroupController {
    @Autowired
    private IPostGroupService postGroupService;
    @Autowired
    private IGroupService groupService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private IImagePostGroupService iImagePostGroupService;
    @Value("C:/Users/nguye/OneDrive/Desktop/image/")
    private String uploadPath;
    @Autowired
    private IImagePostGroupService imagePostGroupService;
    @Autowired
    private IPostService postService;
    @Autowired
    private INotificationCheckStatusService notificationCheckStatusService;
    @Autowired
    private IMessageService messageService;


    @GetMapping("/{groupId}")
    public ResponseEntity<List<PostGroupFrontEnd>> listPost(@PathVariable Long groupId) {
        List<PostGroup> listPost1 = this.postGroupService.listPost(groupId);
        List<PostGroupFrontEnd> listPost2 = new ArrayList<PostGroupFrontEnd>();
        for (int i = 0; i < listPost1.size(); i++) {
            listPost2.add(new PostGroupFrontEnd(listPost1.get(i).getId(),
                                                listPost1.get(i).getContent(),
                                                    this.iImagePostGroupService.listImage(listPost1.get(i).getId()),
                                                    this.postService.getDiffDays(listPost1.get(i).getDateCreated(), new Date()),
                                                listPost1.get(i).getUserInfo()));
        }
        return new ResponseEntity<>(listPost2, HttpStatus.OK);
    }
    @GetMapping("/post/{id}")
    public ResponseEntity<PostGroupFrontEnd> findById(@PathVariable Long id) {
        Optional<PostGroup> postGroup = this.postGroupService.findById(id);
        PostGroupFrontEnd postGroupFrontEnd = new PostGroupFrontEnd();
        postGroupFrontEnd.setPostGroupId(postGroup.get().getId());
        postGroupFrontEnd.setContent(postGroup.get().getContent());
        ImagePostGroup[] images = this.imagePostGroupService.listImage(postGroup.get().getId());
        postGroupFrontEnd.setListImage(images);
        postGroupFrontEnd.setDateCreated(this.postService.getDiffDays(postGroup.get().getDateCreated(), new Date()));
        postGroupFrontEnd.setUserInfo(postGroup.get().getUserInfo());
        return new ResponseEntity<>(postGroupFrontEnd, HttpStatus.OK);
    }

    @PostMapping("/{groupId}/{userId}")
    public ResponseEntity<PostGroup> createPostGroup(@PathVariable Long groupId, @PathVariable Long userId, @ModelAttribute PostUserForm postUserForm) {
        Group group = this.groupService.findById(groupId).get();
        MultipartFile[] listImageFile = postUserForm.getImage();
        List<String> listFileName = new ArrayList<>();
        Optional<UserInfo> userInfoOptional = this.userInfoService.findByUserId(userId);
        // lưu 1 post User
        PostGroup newPostGroup = new PostGroup();
        newPostGroup.setContent(postUserForm.getContent());
        newPostGroup.setDateCreated(new Date());
        newPostGroup.setGroup(group);
        newPostGroup.setUserInfo(userInfoOptional.get());
        if (userInfoOptional.get().getId() == group.getUser().getId()){
            newPostGroup.setStatusCheck(true);
            this.postGroupService.save(newPostGroup);

        }else {
            newPostGroup.setStatusCheck(false);
            this.postGroupService.save(newPostGroup);
            NotificationCheckStatus notificationCheckStatus = new NotificationCheckStatus();
            notificationCheckStatus.setAdmin(group.getUser());
            notificationCheckStatus.setPostGroup(newPostGroup);
notificationCheckStatusService.save(notificationCheckStatus);
Message message  = new Message();
            message.setFromUser(userInfoOptional.get());
            message.setToUser(group.getUser());
            message.setContent(userInfoOptional.get().getFullName() + " đã xin phép đăng 1 bài viết trong nhóm ");
            message.setDateCreated(new Date());
            message.setStatus(4);
            messageService.save(message);
        }
        // đổi tên ảnh sang string và add vào list tên ảnh
        if (listImageFile != null) {
            for (int i = 0; i < listImageFile.length; i++) {
                listFileName.add(listImageFile[i].getOriginalFilename());
            }
            // save ảnh vào trong database và lưu ảnh vào thư mục chứa ảnh
            for (int i = 0; i < listFileName.size(); i++) {
                this.iImagePostGroupService.save(new ImagePostGroup(listFileName.get(i), newPostGroup));
                try {
                    FileCopyUtils.copy(listImageFile[i].getBytes(), new File(uploadPath + listFileName.get(i)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ResponseEntity<>(newPostGroup, HttpStatus.CREATED);
    }

}
