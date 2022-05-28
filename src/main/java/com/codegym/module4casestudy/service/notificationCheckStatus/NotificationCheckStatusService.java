package com.codegym.module4casestudy.service.notificationCheckStatus;

import com.codegym.module4casestudy.model.entity.NotificationCheckStatus;
import com.codegym.module4casestudy.repository.INotificationCheckStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationCheckStatusService implements INotificationCheckStatusService {
    @Autowired
    private INotificationCheckStatusRepository notificationCheckStatusRepository;


    @Override
    public Page<NotificationCheckStatus> findAll(Pageable pageable) {
        return notificationCheckStatusRepository.findAll(pageable);
    }

    @Override
    public Optional<NotificationCheckStatus> findById(Long id) {
        return notificationCheckStatusRepository.findById(id);
    }

    @Override
    public NotificationCheckStatus save(NotificationCheckStatus notificationCheckStatus) {
        return notificationCheckStatusRepository.save(notificationCheckStatus);
    }

    @Override
    public void deleteById(Long id) {
            notificationCheckStatusRepository.deleteById(id);
    }

    @Override
    public List<NotificationCheckStatus> listNoti(Long adminId) {
        return notificationCheckStatusRepository.listNoti(adminId);
    }
}
