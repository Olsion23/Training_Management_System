package com.sda.training_management_system.services;

import com.sda.training_management_system.dao.Class;

import java.util.List;

public interface ClassService {
    Class create(Class entity);
    Class update(Class entity);
    Class findById(Long classId);
    List<Class> findAll();
    String delete(Long classId);

    List<Class> getAllUserClasses();
}
