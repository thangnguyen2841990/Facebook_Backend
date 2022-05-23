package com.codegym.module4casestudy.service.groupMember;

import com.codegym.module4casestudy.model.entity.GroupMember;
import com.codegym.module4casestudy.model.entity.NotificationAddGroup;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IGroupMemberService extends IGeneralService<GroupMember> {
    Optional<NotificationAddGroup> findNotificationAccept(Long fromUserId, Long groupId);

    List<GroupMember> findGroupMemberByGroupId(Long groupId);

    List<GroupMember> findGroupsOfMe(Long userId);

    List<GroupMember> findGroupByUserId(Long groupId);

    Optional<GroupMember> findMemberOut(Long groupId, Long userId);


}
