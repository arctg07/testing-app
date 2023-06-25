package com.example.testing.model;

/**
 * @author Iurii Ivanov
 */

public record Statistic(
        Long totalUsers,
        Long passedUsers,
        Long answeredAllQuestions,
        Long answeredAllQuestionsCorrectly
) {}
