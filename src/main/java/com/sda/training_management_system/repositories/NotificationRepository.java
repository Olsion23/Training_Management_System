package com.sda.training_management_system.repositories;

import com.sda.training_management_system.dao.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
