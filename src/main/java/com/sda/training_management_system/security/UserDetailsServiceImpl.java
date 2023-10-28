package com.sda.training_management_system.security;
import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(username);
        if (user.isPresent()){
            return new UserDetailsImpl(user.get());
        } else {
            throw GenericExceptions.userNotFound();
        }
    }
}
