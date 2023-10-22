package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Role;
import com.sda.training_management_system.repositories.RoleRepository;
import com.sda.training_management_system.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
