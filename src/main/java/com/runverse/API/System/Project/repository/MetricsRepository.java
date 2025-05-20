package com.runverse.API.System.Project.repository;

import com.runverse.API.System.Project.model.Metrics;
import com.runverse.API.System.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetricsRepository extends JpaRepository<Metrics, Long> {
    Optional<Metrics> findByUser(User user);
}
