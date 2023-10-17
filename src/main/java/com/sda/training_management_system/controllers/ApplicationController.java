package com.sda.training_management_system.controllers;

import com.sda.training_management_system.dao.Activity;
import com.sda.training_management_system.dao.Application;
import com.sda.training_management_system.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Application")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping("/all")
    public List<Application> getAll() {
        return applicationService.findAll();
    }

    @GetMapping("/{id}")
    public Application getById(@PathVariable Long id) {
        return applicationService.findById(id);
    }

    @PostMapping("/create")
    public Application create(@RequestBody Application application) {
        return applicationService.create(application);
    }

    @PutMapping("/update")
    public Application update(@RequestBody Application application) {
        return applicationService.update(application);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam Long applicationId) {
        return applicationService.delete(applicationId);
    }
}
