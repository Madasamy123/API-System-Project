package com.runverse.API.System.Project.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin123";  // Your actual admin password
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("New Hashed Password: " + encodedPassword);
    }
}




