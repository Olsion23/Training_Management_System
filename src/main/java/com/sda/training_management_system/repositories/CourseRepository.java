package com.sda.training_management_system.repositories;

import com.sda.training_management_system.dao.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
