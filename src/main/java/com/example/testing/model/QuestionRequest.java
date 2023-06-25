package com.example.testing.model;


import jakarta.validation.constraints.NotNull;

/**
 * @author Iurii Ivanov
 */

public record QuestionRequest(@NotNull String question,
                              @NotNull String correctAnswer) {
}
