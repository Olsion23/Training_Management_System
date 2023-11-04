package com.sda.training_management_system.controllers;

import com.sda.training_management_system.dao.Activity;
import com.sda.training_management_system.dao.Notification;
import com.sda.training_management_system.dao.UserNotification;
import com.sda.training_management_system.services.UserNotificationService;
import com.sda.training_management_system.static_data.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userNotification")
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

    @PostMapping("/sendNotification")
    public ResponseEntity<Response> sendNotification(@RequestBody Notification notification,@RequestParam Long userId){
        return userNotificationService.sendNotification(notification, userId);
    }

}
