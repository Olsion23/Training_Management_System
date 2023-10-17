package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Activity;
import com.sda.training_management_system.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {


    @Override
    public Activity create(Activity entity) {
        return null;
    }

    @Override
    public Activity update(Activity entity) {
        return null;
    }

    @Override
    public Activity findById(Long activityId) {
        return null;
    }

    @Override
    public List<Activity> findAll() {
        return null;
    }

    @Override
    public String delete(Long activityId) {
        return null;
    }
}
