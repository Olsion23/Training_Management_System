package com.sda.training_management_system.services.Impl;

import com.sda.training_management_system.dao.Class;
import com.sda.training_management_system.dao.Course;
import com.sda.training_management_system.exceptions.GenericExceptions;
import com.sda.training_management_system.repositories.ClassRepository;
import com.sda.training_management_system.repositories.CourseRepository;
import com.sda.training_management_system.services.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;
    private final CourseRepository courseRepository;

    @Override
    public Class create(Class entity) {
        Class clazz = entity;
        final Long courseId = entity.getCourse().getCourseId();
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> GenericExceptions.notFound(courseId));
        clazz.setCourse(course);
        clazz = classRepository.save(clazz);
        return clazz;
    }

    @Override
    public Class update(Class entity) {
        Class clazz = this.findById(entity.getClassId());
        if (entity.getSubject() != null)
            clazz.setSubject(entity.getSubject());
        clazz = classRepository.save(clazz);
        return clazz;
    }

    @Override
    public Class findById(Long classId) {
        return classRepository.findById(classId)
                .orElseThrow(() -> GenericExceptions.notFound(classId));
    }

    @Override
    public List<Class> findAll() {
        return classRepository.findAll();
    }

    @Override
    public String delete(Long classId) {
        return null;
    }
}
