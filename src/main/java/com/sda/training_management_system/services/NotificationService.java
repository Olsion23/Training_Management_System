package com.sda.training_management_system.services;

import com.sda.training_management_system.dao.Notification;

import java.util.List;

public interface NotificationService {
    Notification create(Notification entity);
    Notification update(Notification entity);
    Notification findById(Long notificationId);
    List<Notification>findAll();
    String delete(Long notificationId);

}
