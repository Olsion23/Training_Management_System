package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Application;
import com.sda.training_management_system.dao.Course;
import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.ApplicationRepository;
import com.sda.training_management_system.services.ApplicationService;
import com.sda.training_management_system.services.CourseService;
import com.sda.training_management_system.services.UserService;
import com.sda.training_management_system.static_data.ApplicationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final UserService userService;
    private final CourseService courseService;

    @Override
    public Application create(Long courseId) {
        Application application = new Application();
        User user = userService.findUserLoggedIn();
        application.setParticipant(user);
        Course course = courseService.findById(courseId);
        application.setCourse(course);
        application.setLocalDate(LocalDate.now());
        application.setApplicationStatus(ApplicationStatus.CREATED);
        applicationRepository.save(application);
        return application;
    }

    @Override
    public Application refuseApplication(Long applicationId){
        Application application = this.findById(applicationId);
        application.setApplicationStatus(ApplicationStatus.DECLINED);
        applicationRepository.save(application);
        return application;
    }

    @Override
    public Application acceptApplication(Long applicationId){
        Application application = this.findById(applicationId);
        application.setApplicationStatus(ApplicationStatus.ACCEPTED);
        applicationRepository.save(application);
        return application;
    }

    @Override
    public Application findById(Long applicationId) {
        Optional<Application> applicationParticipant = applicationRepository.findById(applicationId);
        return applicationParticipant.orElseThrow(() -> GenericExceptions.notFound(applicationId));
    }

    @Override
    public List<Application> findAll() {
        List<Application> applicationParticipants = applicationRepository.findAll();
        return applicationParticipants;
    }

    @Override
    public List<Application> findAllCreated(){
        return applicationRepository.findAllByStatus(ApplicationStatus.CREATED);
    }
    @Override
    public String delete(Long applicationId) {
        applicationRepository.deleteById(applicationId);
        return String.format("Record with id %d deleted", applicationId);
    }
}

