package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.UserNotification;
import com.sda.training_management_system.services.UserNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserNotificationServiceImpl implements UserNotificationService {
    @Override
    public UserNotification create(UserNotification entity) {
        return null;
    }

    @Override
    public UserNotification update(UserNotification entity) {
        return null;
    }

    @Override
    public UserNotification findById(Long userNotificationId) {
        return null;
    }

    @Override
    public List<UserNotification> findAll() {
        return null;
    }

    @Override
    public String delete(Long userNotificationId) {
        return null;
    }
}
