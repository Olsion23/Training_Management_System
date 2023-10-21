package com.sda.training_management_system.services;

import com.sda.training_management_system.dao.Activity;

import java.util.List;

public interface ActivityService {
    Activity create(Activity entity);

    Activity update(Activity entity);

    Activity findById(Long activityId);

    List<Activity> findAll();

    String delete(Long activityId);
}