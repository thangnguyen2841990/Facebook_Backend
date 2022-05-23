package com.codegym.module4casestudy.service.groupMember;


import com.codegym.module4casestudy.model.entity.GroupMember;
import com.codegym.module4casestudy.model.entity.NotificationAddGroup;
import com.codegym.module4casestudy.repository.IGroupMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GroupMemberService implements IGroupMemberService{
    @Autowired
    private IGroupMemberRepository groupMemberRepository;


    @Override
    public Page<GroupMember> findAll(Pageable pageable) {
        return groupMemberRepository.findAll(pageable);
    }

    @Override
    public Optional<GroupMember> findById(Long id) {
        return groupMemberRepository.findById(id);
    }

    @Override
    public GroupMember save(GroupMember groupMember) {
        return groupMemberRepository.save(groupMember);
    }

    @Override
    public void deleteById(Long id) {
    groupMemberRepository.deleteById(id);
    }

    @Override
    public Optional<NotificationAddGroup> findNotificationAccept(Long fromUserId, Long groupId) {
        return groupMemberRepository.findNotificationAccept(fromUserId, groupId);
    }

    @Override
    public List<GroupMember> findGroupMemberByGroupId(Long groupId) {
        return groupMemberRepository.findGroupMemberByGroupId(groupId);
    }

    @Override
    public List<GroupMember> findGroupsOfMe(Long userId) {
        return groupMemberRepository.findGroupsOfMe(userId);
    }

    @Override
    public List<GroupMember> findGroupByUserId(Long groupId) {
        return this.groupMemberRepository.findGroupByUserId(groupId);
    }

    @Override
    public Optional<GroupMember> findMemberOut(Long groupId, Long userId) {
        return this.groupMemberRepository.findMemberOut(groupId, userId);
    }
}
