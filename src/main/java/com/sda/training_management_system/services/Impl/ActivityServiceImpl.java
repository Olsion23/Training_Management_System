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
    public Activity create(Activity entity) {
        if (entity.getActivityId() != null) {
            throw GenericExceptions.idNotNull();
        } else {
            if (entity.getAClass() != null && entity.getAClass().getClassId() != null) {
                Class existingClass = classRepository.findById(entity.getAClass().getClassId())
                        .orElseThrow(() -> GenericExceptions.notFound(entity.getAClass()));
                entity.setAClass(existingClass);
                activityRepository.save(entity);
                return entity;
            } else {
                throw GenericExceptions.notFound(entity.getAClass());
            }
        }
    }
    @Override
    public Activity update(Activity entity) {
        if (entity.getActivityId() == null) {
            throw GenericExceptions.idIsNull();
        } else {
            Activity existingActivity = activityRepository.findById(entity.getActivityId())
                    .orElseThrow(() -> GenericExceptions.notFound(entity.getActivityId()));
            if (entity.getDate() != null)
                existingActivity.setDate(entity.getDate());
            if (entity.getSubject() != null)
                existingActivity.setSubject(entity.getSubject());
            if (entity.getAClass() != null) {
                Class existingClass = classRepository.findById(entity.getAClass().getClassId())
                        .orElseThrow(()-> GenericExceptions.notFound(entity.getAClass()));
                existingActivity.setAClass(existingClass);
            }
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
        activityRepository.deleteById(activityId);
        return String.format("Record with id %d deleted", activityId);
    }
}