package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Course;
import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.CourseRepository;
import com.sda.training_management_system.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public Course create(Course entity) {
        if (entity.getCourseId() != null)
            throw GenericExceptions.idNotNull();
        else {
            courseRepository.save(entity);
            return entity;
        }
    }

    @Override
    public Course update(Course entity) {
        if (entity.getCourseId() == null) {
            throw GenericExceptions.idIsNull();
        } else {
           Course existingCourse = this.findById(entity.getCourseId());
           if (entity.getCourseName() != null)
               existingCourse.setCourseName(entity.getCourseName());
           courseRepository.save(existingCourse);
           return existingCourse;
        }
    }
    @Override
    public Course findById(Long courseId) {
        Optional<Course> user = courseRepository.findById(courseId);
        return user.orElseThrow(()-> GenericExceptions.notFound(courseId));
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public String delete(Long courseId) {
        courseRepository.findById(courseId);
        return String.format("Record with id %d deleted", courseId);
    }
}
