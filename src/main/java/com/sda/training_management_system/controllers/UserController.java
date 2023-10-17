package com.sda.training_management_system.controllers;

import com.sda.training_management_system.dao.Activity;
import com.sda.training_management_system.dao.User;
import com.sda.training_management_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam Long userId) {
        return userService.delete(userId);
    }
}
