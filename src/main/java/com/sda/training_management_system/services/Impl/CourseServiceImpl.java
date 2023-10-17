package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Course;
import com.sda.training_management_system.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    @Override
    public Course create(Course entity) {
        return null;
    }

    @Override
    public Course update(Course entity) {
        return null;
    }

    @Override
    public Course findById(Long courseId) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public String delete(Long courseId) {
        return null;
    }
}
