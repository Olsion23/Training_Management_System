package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Notification;
import com.sda.training_management_system.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    @Override
    public Notification create(Notification entity) {
        return null;
    }

    @Override
    public Notification update(Notification entity) {
        return null;
    }

    @Override
    public Notification findById(Long notificationId) {
        return null;
    }

    @Override
    public List<Notification> findAll() {
        return null;
    }

    @Override
    public String delete(Long notificationId) {
        return null;
    }
}
