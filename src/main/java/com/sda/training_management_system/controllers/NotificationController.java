package com.sda.training_management_system.controllers;

import com.sda.training_management_system.dao.Activity;
import com.sda.training_management_system.dao.Notification;
import com.sda.training_management_system.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping("/all")
    public List<Notification> getAll() {
        return notificationService.findAll();
    }

    @GetMapping("/{id}")
    public Notification getById(@PathVariable Long id) {
        return notificationService.findById(id);
    }

    @PostMapping("/create")
    public Notification create(@RequestBody Notification notification) {
        return notificationService.create(notification);
    }

    @PutMapping("/update")
    public Notification update(@RequestBody Notification notification) {
        return notificationService.update(notification);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam Long notificationId) {
        return notificationService.delete(notificationId);
    }
}
