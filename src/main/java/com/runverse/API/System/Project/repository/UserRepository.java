package com.runverse.API.System.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.runverse.API.System.Project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);                     // already used in login
    Optional<User> findByUsername(String username);               // used in metrics
    Optional<User> findByEmailAndRole(String email, String role); //  for admin check
}



