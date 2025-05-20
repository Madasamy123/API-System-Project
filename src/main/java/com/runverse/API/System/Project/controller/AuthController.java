package com.runverse.API.System.Project.controller;

import com.runverse.API.System.Project.model.User;
import com.runverse.API.System.Project.service.UserService;
import com.runverse.API.System.Project.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User userRequest) {
        Optional<User> existingUser = userService.findByEmail(userRequest.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists!");
        }

        // Check if the user email exists in DB as ADMIN (e.g., pre-registered admin)
        Optional<User> adminCheck = userService.findByEmailAndRole(userRequest.getEmail(), "ADMIN");

        String roleToSet = adminCheck.isPresent() ? "ADMIN" : "USER";
        userRequest.setRole(roleToSet);

        userService.saveUser(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully with role: " + roleToSet);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        Optional<User> userOptional = userService.findByEmail(email);
        Map<String, String> response = new HashMap<>();

        if (userOptional.isPresent() && userService.checkPassword(password, userOptional.get().getPassword())) {
            String token = jwtUtil.generateToken(email);
            response.put("token", token);
            response.put("role", userOptional.get().getRole());
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
