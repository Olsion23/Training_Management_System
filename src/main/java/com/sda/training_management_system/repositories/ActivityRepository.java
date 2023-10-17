package com.sda.training_management_system.repositories;

import com.sda.training_management_system.dao.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
