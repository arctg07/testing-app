package com.example.testing.model;


import jakarta.validation.constraints.NotNull;

/**
 * @author Iurii Ivanov
 */

public record QuestionWithOptions(@NotNull String question,
                                  @NotNull String correctAnswer,
                                  @NotNull String optionOne,
                                  @NotNull String optionTwo,
                                  @NotNull String optionThree,
                                  @NotNull String optionFour) {
}
