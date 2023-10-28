package com.sda.training_management_system.controllers;

import com.sda.training_management_system.dao.Activity;
import com.sda.training_management_system.dao.Course;
import com.sda.training_management_system.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/all")
    public List<Course> getAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PostMapping("/create")
    public Course create(@RequestBody Course course) {
        return courseService.create(course);
    }

    @PutMapping("/update")
    public Course update(@RequestBody Course course) {
        return courseService.update(course);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam Long courseId) {
        return courseService.delete(courseId);
    }
}
