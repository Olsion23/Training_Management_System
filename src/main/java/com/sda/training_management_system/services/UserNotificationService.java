package com.sda.training_management_system.services;

import com.sda.training_management_system.dao.UserNotification;

import java.util.List;

public interface UserNotificationService {
    UserNotification create(UserNotification entity);
    UserNotification update(UserNotification entity);
    UserNotification findById(Long userNotificationId);
    List<UserNotification>findAll();
    String delete(Long userNotificationId);

}
