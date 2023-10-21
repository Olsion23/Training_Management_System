package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Application;
import com.sda.training_management_system.repositories.ApplicationRepository;
import com.sda.training_management_system.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    @Override
    public Application create(Application entity) {
        return null;
    }

    @Override
    public Application update(Application entity) {
        return null;
    }

    @Override
    public Application findById(Long applicationId) {
        return null;
    }

    @Override
    public List<Application> findAll() {
        return null;
    }

    @Override
    public String delete(Long applicationId) {
        return null;
    }
}
