package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.dto.GroupNameExistDto;
import com.codegym.module4casestudy.model.entity.*;

import com.codegym.module4casestudy.service.group.IGroupService;
import com.codegym.module4casestudy.service.groupMember.IGroupMemberService;
import com.codegym.module4casestudy.service.listFriend.IListFriendService;
import com.codegym.module4casestudy.service.user.IUserService;
import com.codegym.module4casestudy.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/groups")
@CrossOrigin("*")
public class GroupController {
    @Autowired
    private IGroupService groupService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IGroupMemberService groupMemberService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IListFriendService listFriendService;

    @GetMapping()
    public ResponseEntity<Page<Group>> findAllGroup(@PageableDefault(value = 100) Pageable pageable) {
        Page<Group> groups = groupService.findAll(pageable);
        if (groups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> findGroupById(@PathVariable Long id) {
        Optional<Group> optionalGroup = groupService.findById(id);
        if (!optionalGroup.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalGroup.get(), HttpStatus.OK);
    }

    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<Page<Group>> findAllGroupByCreateUserId(@PathVariable Long userId, @PageableDefault(value = 100) Pageable pageable) {
        UserInfo admin = this.userInfoService.findByUserId(userId).get();
        Page<Group> groups = groupService.findByUserId(admin.getId(), pageable);
        if (groups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping("/findByOtherUserId/{userId}")
    public ResponseEntity<Page<Group>> findAllGroupOtherUserId(@PathVariable Long userId, @PageableDefault(value = 100) Pageable pageable) {
        UserInfo userInfo = this.userInfoService.findByUserId(userId).get();
        Page<Group> groups = groupService.findAllGroupOtherUserId(userInfo.getId(), pageable);
        if (groups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }


    @PostMapping("/{userId}")
    public ResponseEntity<Group> createGroup(@RequestBody Group group, @PathVariable Long userId) {
        Optional<UserInfo> admin = this.userInfoService.findByUserId(userId);
        Optional<User> user = this.iUserService.findById(userId);
        group.setUser(admin.get());
        group.setAvatar("1651423516341minh.png");
        Group newGroup = this.groupService.save(group);


        groupMemberService.save(new GroupMember(group, admin.get(), 0));
        return new ResponseEntity<>(newGroup, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> editGroup(@PathVariable Long id, @RequestBody Group group) {
        Optional<Group> optionalGroup = groupService.findById(id);
        Group newGroup = optionalGroup.get();
        if (!optionalGroup.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        newGroup.setId(id);
        newGroup.setName(group.getName());
        newGroup.setGroupStatus(group.getGroupStatus());
        this.groupService.save(newGroup);
        return new ResponseEntity<>(newGroup, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable Long id) {
        Optional<Group> optionalGroup = groupService.findById(id);
        if (!optionalGroup.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        groupService.deleteById(id);
        return new ResponseEntity<>(optionalGroup.get(), HttpStatus.OK);
    }

    @GetMapping("/checkNameExist/{id}/{name}")
    public ResponseEntity<GroupNameExistDto> groupNameExistCheck(@PathVariable String name, @PathVariable Long id) {
        List<Group> groups = this.groupService.findAllGroupOfUser(id);
        GroupNameExistDto nameExistDto = new GroupNameExistDto();
        nameExistDto.setStatus(false);
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getName().equals(name)) {
                nameExistDto.setStatus(true);
                break;
            }
        }
        return new ResponseEntity<>(nameExistDto, HttpStatus.OK);
    }
    @GetMapping("/add/user/{id}/{groupId}")
    public ResponseEntity<List<ListFriend>> listUserAdd(@PathVariable Long id, @PathVariable Long groupId) {
        UserInfo userInfo = this.userInfoService.findByUserId(id).get();
        List<ListFriend> listUser = this.listFriendService.listUserAdd(userInfo.getId(), groupId);
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }
}
