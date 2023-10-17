package com.sda.training_management_system.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Notifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue
    private Long notificationId;
    @ManyToOne
    private Class aClass;

    private String subject;
    private String content;

}
