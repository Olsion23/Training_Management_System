package com.sda.training_management_system.services;

import com.sda.training_management_system.dao.Application;
import org.springframework.context.ApplicationListener;

import java.util.List;

public interface ApplicationService {
    Application create(Long courseId);

    Application refuseApplication(Long applicationId);

    Application acceptApplication(Long applicationId);

    Application findById(Long applicationId);
    List<Application> findAll();

    List<Application> findAllCreated();

    String delete(Long applicationId);

}
