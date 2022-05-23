package com.codegym.module4casestudy.service.chat;

import com.codegym.module4casestudy.model.entity.Chat;
import com.codegym.module4casestudy.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IChatService extends IGeneralService<Chat> {
    Optional<Chat> findChat(Long user1Id, Long user2Id);
    List<Chat> getAllChatByUser(Long userId);


}
