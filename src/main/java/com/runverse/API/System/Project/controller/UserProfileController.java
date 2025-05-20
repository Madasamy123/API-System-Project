package com.runverse.API.System.Project.controller;

import com.runverse.API.System.Project.model.UserProfileUpdate;

import com.runverse.API.System.Project.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable Long id,
            @RequestBody UserProfileUpdate updateRequest) {

        userProfileService.updateUserById(id, updateRequest);
        return ResponseEntity.ok("User updated successfully");
    }
}
