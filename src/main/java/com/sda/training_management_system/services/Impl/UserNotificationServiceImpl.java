package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.dao.UserNotification;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.UserNotificationRepository;
import com.sda.training_management_system.services.UserNotificationService;
import com.sda.training_management_system.services.UserService;
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
    private final UserService userService;
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
        Optional<UserNotification> userNotification = userNotificationRepository.findById(userNotificationId);
        return userNotification.orElseThrow(()-> GenericExceptions.notFound(userNotificationId));
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

    @Override
    public List<UserNotification> findAllByUserLoggedIn(){
        User user = userService.findUserLoggedIn();
        return user.getNotifications();
    }

    @Override
    public void readNotification(Long userNotificationId){
        UserNotification userNotification = this.findById(userNotificationId);
        userNotification.setReaded(true);
        userNotificationRepository.save(userNotification);
    }

}
