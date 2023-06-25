package com.example.testing.service;

import com.example.testing.model.AnswerRequest;
import com.example.testing.model.Statistic;
import com.example.testing.model.TestQuestion;

import java.util.List;

/**
 * @author Iurii Ivanov
 */

public interface TestService {

    String answer(String userId, AnswerRequest answerRequest);

    List<AnswerRequest> getAnswers();

    Statistic getCommonStatistics();

    Statistic getUserStatistics();

    TestQuestion getQuestion(String userId);
}
