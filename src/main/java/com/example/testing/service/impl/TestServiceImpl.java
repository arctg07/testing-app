package com.example.testing.service.impl;

import com.example.testing.database.entity.Answer;
import com.example.testing.database.entity.Question;
import com.example.testing.database.repository.AnswerRepository;
import com.example.testing.exception.TestingException;
import com.example.testing.model.AnswerRequest;
import com.example.testing.model.Statistic;
import com.example.testing.model.TestQuestion;
import com.example.testing.service.QuestionService;
import com.example.testing.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Iurii Ivanov
 */

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    @Override
    public String answer(String userId, AnswerRequest answerRequest) {
        Question question = questionService.getQuestion(Long.parseLong(answerRequest.questionId()));
        checkAnswer(userId, answerRequest.questionId());

        boolean result = answerRequest.answer().equalsIgnoreCase(question.getCorrectAnswer());

        Answer answer = Answer.builder()
                .answer(answerRequest.answer())
                .questionId(Long.parseLong(answerRequest.questionId()))
                .userId(Long.parseLong(userId))
                .result(result)
                .build();

        answerRepository.save(answer);

        return result ? String.format("Correct: %s.", answerRequest.answer()) :
                String.format("Wrong: %s.", answerRequest.answer());
    }

    @Override
    public TestQuestion getQuestion(String userId) {
        return questionService.getTestQuestion(userId);
    }

    @Override
    public List<AnswerRequest> getAnswers() {
        return null;
    }

    @Override
    public Statistic getCommonStatistics() {
        return null;
    }

    @Override
    public Statistic getUserStatistics() {
        return null;
    }


    private void checkAnswer(String userId, String questionId) {
        boolean result = answerRepository.existsByUserIdAndAndQuestionId(Long.parseLong(userId),
                Long.parseLong(questionId));

        if (result) throw new TestingException("Already answered this question");
    }
}
