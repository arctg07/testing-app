package com.example.testing.model;

/**
 * @author Iurii Ivanov
 */

public record UserStatistics(
    Double currentUserPercentage,
    Double worseUsersPercentage,
    Double betterUsersPercentage
) {}
