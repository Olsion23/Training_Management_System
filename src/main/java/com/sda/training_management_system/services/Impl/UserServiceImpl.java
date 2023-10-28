package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.RoleRepository;
import com.sda.training_management_system.repositories.UserRepository;
import com.sda.training_management_system.security.AuthRequest;
import com.sda.training_management_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    @Override
    public User create(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        userRepository.save(entity);
        entity.setActive(true);
        return entity;
    }

    @Override
    public User update(User entity) {
        if (entity.getUserId() == null) {
            throw GenericExceptions.idIsNull();
        } else {
            Optional<User> existingUser = userRepository.findById(entity.getUserId());
            if (existingUser.isPresent()) {
                userRepository.save(entity);
            }
        }
        return entity;
    }

    @Override
    public User findById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(()-> GenericExceptions.notFound(userId));

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public String delete(Long userId) {
        userRepository.findById(userId);
        return String.format("Record with id %d deleted", userId);
    }

    @Override
    public User findUserLoggedIn() {
        return userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(GenericExceptions::userNotFound);
    }


    @Override
    public ResponseEntity<?> login(AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                            authRequest.getPassword()));
            return ResponseEntity.ok(authentication.getPrincipal());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    public User register(User user) {
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(roleRepository.findById("ROLE_PARTICIPANT").get());
            userRepository.save(user);
            return user;
    }
}
