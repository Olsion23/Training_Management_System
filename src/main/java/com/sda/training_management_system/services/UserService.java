package com.sda.training_management_system.services;

import com.sda.training_management_system.dao.User;

import java.util.List;

public interface UserService {
    User create(User entity);
    User update(User entity);
    User findById(Long userId);
    List<User>findAll();
    String delete(Long userId);
}
