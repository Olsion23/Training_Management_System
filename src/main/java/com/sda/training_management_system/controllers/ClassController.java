package com.sda.training_management_system.controllers;

import com.sda.training_management_system.dao.Activity;
import com.sda.training_management_system.dao.Class;
import com.sda.training_management_system.services.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Class")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;

    @GetMapping("/all")
    public List<Class> getAll() {
        return classService.findAll();
    }

    @GetMapping("/{id}")
    public Class getById(@PathVariable Long id) {
        return classService.findById(id);
    }

    @PostMapping("/create")
    public Class create(@RequestBody Class classes) {
        return classService.create(classes);
    }

    @PutMapping("/update")
    public Class update(@RequestBody Class classes) {
        return classService.update(classes);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam Long classId) {
        return classService.delete(classId);
    }
}