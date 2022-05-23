package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.dto.UserDTO;
import com.codegym.module4casestudy.model.entity.ListFriend;
import com.codegym.module4casestudy.model.entity.User;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.listFriend.IListFriendService;
import com.codegym.module4casestudy.service.user.IUserService;
import com.codegym.module4casestudy.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IListFriendService listFriendService;

    @GetMapping("/all/{id}")
    public ResponseEntity<List<UserDTO>> getAllUser(@PathVariable Long id) {
        List<UserInfo> userInfos = userInfoService.showAllUserInfo(id);
        List<UserDTO> userDTOList = new ArrayList<>();
        if (userInfos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (int i = 0; i < userInfos.size(); i++) {
            userDTOList.add(new UserDTO(userInfos.get(i).getUser().getId(),
                    userInfos.get(i).getUser().getUsername(),
                    userInfos.get(i).getUser().getCreateDate(),
                    this.listFriendService.findAll(userInfos.get(i).getId()).size(),
                    userInfos.get(i).getUser().getBlockStatus()));
        }
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable Long userId) {
        Optional<User> optionalUser = this.userService.findById(userId);
        if (!optionalUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> blockUser(@PathVariable long userId) {
        Optional<User> optionalUser = this.userService.findById(userId);
        if (!optionalUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        optionalUser.get().setBlockStatus(true);
        this.userService.saveBlock(optionalUser.get());
        return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);

    }
    @PutMapping("/unlock/{userId}")
    public ResponseEntity<User> unlockUser(@PathVariable Long userId) {
        Optional<User> optionalUser = this.userService.findById(userId);
        if (!optionalUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        optionalUser.get().setBlockStatus(false);
        this.userService.saveBlock(optionalUser.get());
        return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);

    }
}
