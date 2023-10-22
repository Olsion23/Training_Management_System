package com.sda.training_management_system.repositories;

import com.sda.training_management_system.dao.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
