package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public User findById(Long userId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public String delete(Long userId) {
        return null;
    }
}
