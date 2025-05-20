package com.runverse.API.System.Project.controller;

import com.runverse.API.System.Project.model.Metrics;
import com.runverse.API.System.Project.model.User;
import com.runverse.API.System.Project.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    //  1. User adds/updates their metrics
    @PostMapping("/user")
    public Metrics addMyMetrics(@RequestBody Metrics metrics, Authentication authentication) {
        String username = authentication.getName();
        return metricsService.addMyMetrics(username, metrics);
    }

    //   User views their own metrics
    @GetMapping("/user")
    public Metrics getMyMetrics(Authentication authentication) {
        String email = authentication.getName();
        System.out.println(email);
        return metricsService.getMetricsByUserEmail(email);
    }



    // User delete  metrics

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteMetrics(@PathVariable Long id) {
        try {
            metricsService.deleteMetricsByUserId(id);
            return ResponseEntity.ok("Metrics deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    //  Admin views all metrics

    @GetMapping("/admin/all")
    public List<Metrics> getAllMetrics() {
        return metricsService.getAllMetrics();
    }




    //   Admin views metrics by user ID
    @GetMapping("/admin/user/{userId}")
    public Metrics getMetricsByUserId(@PathVariable Long userId) {
        return metricsService.getMetricsByUserId(userId);
    }
}
