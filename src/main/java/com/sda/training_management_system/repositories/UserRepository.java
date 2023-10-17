package com.sda.training_management_system.repositories;

import com.sda.training_management_system.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
