package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.dao.UserNotification;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.UserNotificationRepository;
import com.sda.training_management_system.services.UserNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserNotificationServiceImpl implements UserNotificationService {
    private final UserNotificationRepository userNotificationRepository;
    @Override
    public UserNotification create(UserNotification entity) {
        return null;
    }

    @Override
    public UserNotification update(UserNotification entity) {
        if (entity.getUserNotificationId() == null) {
            throw GenericExceptions.idIsNull();
        } else {
            Optional<UserNotification> existingUser = userNotificationRepository.findById(entity.getUserNotificationId());
            if (existingUser.isPresent()) {
                userNotificationRepository.save(entity);
            }
        }
        return entity;
    }

    @Override
    public UserNotification findById(Long userNotificationId) {
        Optional<UserNotification> user = userNotificationRepository.findById(userNotificationId);
        return user.orElseThrow(()-> GenericExceptions.notFound(userNotificationId));
    }

    @Override
    public List<UserNotification> findAll() {
        return userNotificationRepository.findAll();
    }

    @Override
    public String delete(Long userNotificationId) {
        userNotificationRepository.deleteById(userNotificationId);
        return String.format("Record with id %d deleted", userNotificationId);
    }
}
