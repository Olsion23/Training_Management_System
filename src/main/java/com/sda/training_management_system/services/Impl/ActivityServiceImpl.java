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
        if(activity.getActivityId()==null){
            throw GenericExceptions.idNotNull();
        } else if (activityRepository.existsById(activity.getActivityId())) {
            throw GenericExceptions.idExist(activity.getActivityId());

        }else activityRepository.save(activity);
        return activity;
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
        List<Activity>activityList=activityRepository.findAll();
        return activityList;
    }

    @Override
    public String delete(Long activityId) {
        Optional<Activity>activity=activityRepository.findById(activityId);
        if(activity.isPresent()){
            activityRepository.deleteById(activityId);
            return String.format("Record with id %d deleted", activityId);
        }else throw  GenericExceptions.notFound(activityId);

    }
}