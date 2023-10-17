package com.sda.training_management_system.repositories;

import com.sda.training_management_system.dao.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
