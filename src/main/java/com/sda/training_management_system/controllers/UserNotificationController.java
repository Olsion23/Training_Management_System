package com.sda.training_management_system.controllers;

import com.sda.training_management_system.dao.Activity;
import com.sda.training_management_system.dao.UserNotification;
import com.sda.training_management_system.services.UserNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserNotification")
@RequiredArgsConstructor
public class UserNotificationController {
    private final UserNotificationService userNotificationService;

    @GetMapping("/all")
    public List<UserNotification> getAll() {
        return userNotificationService.findAll();
    }

    @GetMapping("/{id}")
    public UserNotification getById(@PathVariable Long id) {
        return userNotificationService.findById(id);
    }

    @PostMapping("/create")
    public UserNotification create(@RequestBody UserNotification userNotification) {
        return userNotificationService.create(userNotification);
    }

    @PutMapping("/update")
    public UserNotification update(@RequestBody UserNotification userNotification) {
        return userNotificationService.update(userNotification);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam Long userNotificationId) {
        return userNotificationService.delete(userNotificationId);
    }
    @GetMapping("/all_user_notifications")
    public List<UserNotification> findAllByUserLoggedIn(){
        return userNotificationService.findAllByUserLoggedIn();
    }
    @GetMapping("/read_notifications")
    public void readNotification(@RequestParam Long userNotificationId){
        userNotificationService.readNotification(userNotificationId);
    }

}
