package com.example.testing.service.impl;

import com.example.testing.database.entity.Question;
import com.example.testing.database.repository.QuestionRepository;
import com.example.testing.exception.NotFoundException;
import com.example.testing.exception.TestingException;
import com.example.testing.mapper.QuestionMapper;
import com.example.testing.model.QuestionRequest;
import com.example.testing.model.QuestionWithOptions;
import com.example.testing.model.TestQuestion;
import com.example.testing.service.QuestionService;
import com.example.testing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Iurii Ivanov
 */

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;

    private final QuestionRepository questionRepository;

    private final UserService userService;

    @Override
    public void addQuestion(QuestionRequest request) {
        Question question = questionMapper.toEntity(request);

        questionRepository.save(question);
    }

    @Override
    public void addQuestion(QuestionWithOptions request) {
        Question question = questionMapper.toEntity(request);

        questionRepository.save(question);
    }

    @Override
    public TestQuestion getTestQuestion(String userId) {
        userService.checkUserById(Long.parseLong(userId));
        Question question = questionRepository.getTestQuestion(Long.parseLong(userId))
                .orElseThrow(
                        () -> new TestingException("you answered all the questions"));

        return questionMapper.toTestView(question);
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Question.class, id.toString())
        );
    }
}
