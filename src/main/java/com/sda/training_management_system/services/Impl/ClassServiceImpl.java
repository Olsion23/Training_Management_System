package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Class;
import com.sda.training_management_system.services.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    @Override
    public Class create(Class entity) {
        return null;
    }

    @Override
    public Class update(Class entity) {
        return null;
    }

    @Override
    public Class findById(Long classId) {
        return null;
    }

    @Override
    public List<Class> findAll() {
        return null;
    }

    @Override
    public String delete(Long classId) {
        return null;
    }
}
