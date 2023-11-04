package com.sda.training_management_system.services;

import com.sda.training_management_system.dao.Notification;
import com.sda.training_management_system.dao.UserNotification;
import com.sda.training_management_system.static_data.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserNotificationService {
    UserNotification create(UserNotification entity);
    UserNotification update(UserNotification entity);
    UserNotification findById(Long userNotificationId);
    List<UserNotification>findAll();
    String delete(Long userNotificationId);

    List<UserNotification> findAllByUserLoggedIn();

    void readNotification(Long userNotificationId);

    ResponseEntity<Response> sendNotification(Notification notification, Long userId);
}
