package com.codegym.module4casestudy.service.message;

import com.codegym.module4casestudy.model.entity.Message;
import com.codegym.module4casestudy.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService implements IMessageService{
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Page<Message> findAll(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public List<Message> findAllMessage(Long to_user_id) {
        return this.messageRepository.findAllMessage(to_user_id);
    }

    @Override
    public void deleteMessage(Long toUserId) {
        messageRepository.deleteMessage(toUserId);
    }
}
