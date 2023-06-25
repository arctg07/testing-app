package com.example.testing.service;

import com.example.testing.database.repository.StatisticRepository;
import com.example.testing.model.Statistic;
import com.example.testing.model.UserStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Iurii Ivanov
 */

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticRepository repository;

    @Override
    public Statistic getStatistics() {
        return repository.getFullStatistics();
    }

    @Override
    public UserStatistics getUserStatistics(String userId) {
        return repository.getUserStatistics(Long.parseLong(userId));
    }
}
