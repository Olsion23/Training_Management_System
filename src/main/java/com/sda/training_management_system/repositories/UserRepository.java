package com.sda.training_management_system.repositories;

import com.sda.training_management_system.dao.Role;
import com.sda.training_management_system.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User> findByLogin(String login);
   Boolean existsByLogin(String login);

   @Query("select u from User u where u.role = :role")
    List<User> getByRole(Role role);
}
