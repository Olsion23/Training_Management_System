package com.sda.training_management_system.controllers;

import com.sda.training_management_system.dao.Role;
import com.sda.training_management_system.repositories.RoleRepository;
import com.sda.training_management_system.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RoleController")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    @GetMapping("/all")
    public List<Role> getAll(){
        return roleService.getAll();
    }
}
