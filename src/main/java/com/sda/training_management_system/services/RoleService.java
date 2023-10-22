package com.sda.training_management_system.services;

import com.sda.training_management_system.dao.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    List<Role> getAll();

}
