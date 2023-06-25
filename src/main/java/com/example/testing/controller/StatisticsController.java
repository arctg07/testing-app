package com.example.testing.controller;

import com.example.testing.model.Statistic;
import com.example.testing.model.UserStatistics;
import com.example.testing.service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Iurii Ivanov
 */

@RestController
@RequestMapping("/testing/statistics")
@Tag(name = "Statistics controller", description = "API for work getting statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService service;

    @GetMapping
    @Operation(summary = "GET FULL STATISTICS", description = "GET FULL STATISTICS")
    public Statistic getStatistics() {
        return service.getStatistics();
    }

    @GetMapping("/{userId}")
    @Operation(summary = "GET STATISTICS FOR PARTICULAR USER", description = "GET STATISTICS FOR PARTICULAR USER")
    public UserStatistics getStatisticsForUser(@PathVariable String userId) {
        return service.getUserStatistics(userId);
    }
}
