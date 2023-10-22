package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.UserRepository;
import com.sda.training_management_system.security.AuthRequest;
import com.sda.training_management_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public User create(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
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

    @Override
    public User findUserLoggedIn() {
        return userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(()-> GenericExceptions.userNotFound());
    }


    @Override
    public ResponseEntity<?> login(AuthRequest authRequest) {
        return null;
    }

    @Override
    public User register(User user) {
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return user;
    }
    public User FindUserLoggedIn(){
        return userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(GenericExceptions::userNotFound);
    }
}
