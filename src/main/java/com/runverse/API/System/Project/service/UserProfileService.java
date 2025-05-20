package com.runverse.API.System.Project.service;

import com.runverse.API.System.Project.model.User;
import com.runverse.API.System.Project.model.UserProfileUpdate;
import com.runverse.API.System.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void updateUserById(Long id, UserProfileUpdate updateRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (updateRequest.getName() != null && !updateRequest.getName().isEmpty()) {
            user.setUsername(updateRequest.getName());
        }

        if (updateRequest.getPassword() != null && !updateRequest.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(updateRequest.getPassword()));
        }

        userRepository.save(user);
    }
}
