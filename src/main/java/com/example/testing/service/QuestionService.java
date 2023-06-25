package com.example.testing.service;

import com.example.testing.database.entity.Question;
import com.example.testing.model.QuestionRequest;
import com.example.testing.model.QuestionWithOptions;
import com.example.testing.model.TestQuestion;

/**
 * @author Iurii Ivanov
 */

public interface QuestionService {
    void addQuestion(QuestionRequest question);

    void addQuestion(QuestionWithOptions request);

    TestQuestion getTestQuestion(String userId);

    Question getQuestion(Long id);
}
