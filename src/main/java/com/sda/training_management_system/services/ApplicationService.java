package com.sda.training_management_system.services;

import com.sda.training_management_system.dao.Application;
import org.springframework.context.ApplicationListener;

import java.util.List;

public interface ApplicationService {
    Application create(Application entity);
    Application update(Application entity);
    Application findById(Long applicationId);
    List<Application> findAll();
    String delete(Long applicationId);

}
