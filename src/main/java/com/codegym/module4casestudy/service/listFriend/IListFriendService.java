package com.codegym.module4casestudy.service.listFriend;

import com.codegym.module4casestudy.model.entity.ListFriend;
import com.codegym.module4casestudy.model.entity.NotificationAddFriends;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IListFriendService extends IGeneralService<ListFriend> {
    List<ListFriend> findAll(Long toUserId);

    Optional<ListFriend> findFriends(Long fromUserId, Long toUserId);

    List<ListFriend> listUserAdd(Long userID, Long groupId);

}
