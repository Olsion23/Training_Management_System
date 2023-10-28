package com.sda.training_management_system.repositories;

import com.sda.training_management_system.dao.Application;
import com.sda.training_management_system.static_data.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Query(value = "select a from Application a where a.applicationStatus = :status")
    List<Application> findAllByStatus(@Param("status") ApplicationStatus applicationStatus);
}
