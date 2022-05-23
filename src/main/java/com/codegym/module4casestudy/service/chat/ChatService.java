package com.codegym.module4casestudy.service.chat;

import com.codegym.module4casestudy.model.entity.Chat;
import com.codegym.module4casestudy.repository.IChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService implements IChatService{
    @Autowired
    private IChatRepository IChatRepository;
    @Override
    public Page<Chat> findAll(Pageable pageable) {
        return IChatRepository.findAll(pageable);
    }

    @Override
    public Optional<Chat> findById(Long id) {
        return IChatRepository.findById(id);
    }

    @Override
    public Chat save(Chat chat) {
        return IChatRepository.save(chat);
    }

    @Override
    public void deleteById(Long id) {
        IChatRepository.deleteById(id);
    }

    @Override
    public Optional<Chat> findChat(Long user1Id, Long user2Id) {
        return IChatRepository.findChat(user1Id, user2Id);
    }

    @Override
    public List<Chat> getAllChatByUser(Long userId) {
        return this.IChatRepository.getAllChatByUser(userId);
    }
}
