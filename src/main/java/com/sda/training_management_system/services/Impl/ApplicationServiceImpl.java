package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Application;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.ApplicationRepository;
import com.sda.training_management_system.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    @Override
    public Application create(Application application) {
        if (application.getApplicationId()== null){
            throw GenericExceptions.idNotNull();
        } else if(applicationRepository.existsById(application.getApplicationId())) {
            throw GenericExceptions.idExist(application.getApplicationId());
        } else {
            applicationRepository.save(application);
            return application;
        }
    }

    @Override
    public Application update(Application application) {
        if (application.getApplicationId() == null){
            throw GenericExceptions.idIsNull();
        } else {
            Optional<Application> applicationOptional = applicationRepository.findById(application.getApplicationId());
            if ((applicationOptional.isPresent() && applicationOptional.get().getApplicationId().equals(application.getApplicationId()))
            ){
                applicationRepository.save(application);
                return application;
            }  else {
                throw GenericExceptions.notFound(application.getApplicationId());
            }
        }
    }

    @Override
    public Application findById(Long applicationId) {
        Optional<Application>applicationParticipant=applicationRepository.findById(applicationId);
        return applicationParticipant.orElseThrow(()-> GenericExceptions.notFound(applicationId));
    }

    @Override
    public List<Application> findAll() {
        List<Application>applicationParticipants=applicationRepository.findAll();
        return applicationParticipants;
    }

    @Override
    public String delete(Long applicationId) {
        Optional<Application>applicationOptional=applicationRepository.findById(applicationId);
        if(applicationOptional.isPresent()){
            applicationRepository.deleteById(applicationId);
            return String.format("Record with id %d deleted", applicationId);
        }else throw  GenericExceptions.notFound(applicationId);
    }
    }

