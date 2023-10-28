package com.sda.training_management_system.controllers;

import com.sda.training_management_system.dao.Activity;
import com.sda.training_management_system.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    @GetMapping("/all")
    public List<Activity>getAll(){
        return activityService.findAll();
    }
    @GetMapping("/{id}")
    public Activity getById(@PathVariable Long id) {
        return activityService.findById(id);
    }
    @PostMapping("/create")
    public Activity create(@RequestBody Activity activity){
        return activityService.create(activity);
    }
    @PutMapping("/update")
    public Activity update(@RequestBody Activity activity){
        return activityService.update(activity);
    }
    @DeleteMapping("/delete")
    public String deleteById(@RequestParam Long activityId){
        return activityService.delete(activityId);

    }
}
