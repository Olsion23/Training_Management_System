package com.sda.training_management_system.repositories;

import com.sda.training_management_system.dao.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {

}
