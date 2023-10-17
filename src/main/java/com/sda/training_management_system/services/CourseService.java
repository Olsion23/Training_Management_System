package com.sda.training_management_system.services;

import com.sda.training_management_system.dao.Course;

import java.util.List;

public interface CourseService {
    Course create(Course entity);
    Course update(Course entity);
    Course findById(Long courseId);
    List<Course>findAll();
    String delete(Long courseId);

}
