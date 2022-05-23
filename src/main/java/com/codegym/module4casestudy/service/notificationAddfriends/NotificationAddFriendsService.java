package com.codegym.module4casestudy.service.notificationAddfriends;

import com.codegym.module4casestudy.model.entity.NotificationAddFriends;
import com.codegym.module4casestudy.repository.NotifiCationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationAddFriendsService implements INotificationAddFriendsService {

    @Autowired
    private NotifiCationRepository notifiCationRepository;

    @Override
    public Page<NotificationAddFriends> findAll(Pageable pageable) {
        return notifiCationRepository.findAll(pageable);
    }

    @Override
    public Optional<NotificationAddFriends> findById(Long id) {
        return notifiCationRepository.findById(id);
    }

    @Override
    public NotificationAddFriends save(NotificationAddFriends notificationAddFriends) {
        return notifiCationRepository.save(notificationAddFriends);
    }

    @Override
    public void deleteById(Long id) {
        notifiCationRepository.deleteById(id);
    }

    @Override
    public List<NotificationAddFriends> showNotifications(Long toUserId) {
        return notifiCationRepository.showNotifications(toUserId);
    }

    @Override
    public Optional<NotificationAddFriends> findNotificationAddFriends(Long fromUserId, Long toUserId) {
        return this.notifiCationRepository.findNotificationAddFriends(fromUserId, toUserId);
    }

    @Override
    public List<NotificationAddFriends> showAllSendNotifications(Long fromUserId) {
        return this.notifiCationRepository.showAllSendNotifications(fromUserId);
    }
}
