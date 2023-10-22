package com.sda.training_management_system.security;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;


}
