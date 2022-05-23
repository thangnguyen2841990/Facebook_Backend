package com.codegym.module4casestudy.service.chat1;

import com.codegym.module4casestudy.model.entity.Chat1;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;

public interface IChat1Service extends IGeneralService<Chat1> {
    Iterable<Chat1> getAllHistoryBetweenTwoUser(Long user1Id, Long user2Id);

    List<Chat1> listChatOfMe(Long senderId, Long receiverId);


}
