package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Activity;
import com.sda.training_management_system.dao.Class;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.ActivityRepository;
import com.sda.training_management_system.repositories.ClassRepository;
import com.sda.training_management_system.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final ClassRepository classRepository;

    @Override
    public Activity create(Activity activity) {
        if (activity.getActivityId() == null) {
            throw GenericExceptions.idNotNull();
        } else {
            Class existingClass = classRepository.findById(activity.getAClass().getClassId())
                    .orElseThrow(() -> GenericExceptions.notFound(activity.getAClass()));
            activity.setAClass(existingClass);
            activityRepository.save(activity);
            return activity;
        }
    }

    @Override
    public Activity update(Activity entity) {
        if (entity.getActivityId() == null) {
            throw GenericExceptions.idIsNull();
        } else {
            Activity existingActivity = this.findById(entity.getActivityId());
            if (entity.getDate() != null)
                existingActivity.setDate(entity.getDate());
            if (entity.getSubject() != null)
                existingActivity.setSubject(entity.getSubject());
            activityRepository.save(existingActivity);
            return existingActivity;
        }
    }

    @Override
    public Activity findById(Long activityId) {
        Optional<Activity> activity = activityRepository.findById(activityId);
        return activity.orElseThrow(() -> GenericExceptions.notFound(activityId));
    }

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public String delete(Long activityId) {
        Activity activity = this.findById(activityId);
        activityRepository.delete(activity);
        return String.format("Record with id %d deleted", activityId);
    }

    @Override
    public List<Activity> getAllByClass(Long classId){
        Class clazz = classRepository.findById(classId)
                .orElseThrow(()-> GenericExceptions.notFound(classId));
        return clazz.getActivities();
    }
}