package com.example.testing.service;

import com.example.testing.model.Statistic;
import com.example.testing.model.UserStatistics;

/**
 * @author Iurii Ivanov
 */

public interface StatisticsService {

    Statistic getStatistics();

    UserStatistics getUserStatistics(String userId);
}
