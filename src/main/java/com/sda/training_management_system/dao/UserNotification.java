package com.sda.training_management_system.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User_Notifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNotification {
    @Id
    @GeneratedValue
    private Long userNotificationId;
    @ManyToOne
    private User user;
    @ManyToOne
    private Notification notification;
    private boolean readed;
}
