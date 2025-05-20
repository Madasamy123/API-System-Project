package com.runverse.API.System.Project.service;

import com.runverse.API.System.Project.model.Metrics;
import com.runverse.API.System.Project.model.User;
import com.runverse.API.System.Project.repository.MetricsRepository;
import com.runverse.API.System.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetricsService {

    @Autowired
    private MetricsRepository metricsRepository;

    @Autowired
    private UserRepository userRepository;

    public Metrics addMyMetrics(String email, Metrics newMetrics) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        System.out.println("Username received in controller: " + email);


        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = userOpt.get();

        Optional<Metrics> existing = metricsRepository.findByUser(user);
        Metrics metrics = existing.orElse(new Metrics(user));

        metrics.setHydration(newMetrics.getHydration());
        metrics.setFatigue(newMetrics.getFatigue());
        metrics.setPosture(newMetrics.getPosture());
        metrics.setHeartRate(newMetrics.getHeartRate());
        metrics.setSteps(newMetrics.getSteps());
        metrics.setSleepHours(newMetrics.getSleepHours());

        return metricsRepository.save(metrics);
    }

    public Metrics getMetricsByUserEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return metricsRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Metrics not found"));
    }

    //

    public void deleteMetricsByUserId(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        Metrics metrics = metricsRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Metrics not found for user id: " + id));

        metricsRepository.delete(metrics);
    }






    public List<Metrics> getAllMetrics() {
        return metricsRepository.findAll();
    }



    public Metrics getMetricsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return metricsRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Metrics not found"));
    }



}
