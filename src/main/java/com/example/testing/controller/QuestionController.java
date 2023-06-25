package com.example.testing.controller;

import com.example.testing.model.QuestionRequest;
import com.example.testing.model.QuestionWithOptions;
import com.example.testing.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Iurii Ivanov
 */

@RestController
@RequestMapping("/testing/questions")
@Tag(name = "Question controller", description = "API for work with question-service")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/create")
    @Operation(summary = "CREATE QUESTION", description = "CREATE QUESTION")
    public void create(@RequestBody QuestionRequest question) {
        questionService.addQuestion(question);
    }

    @PostMapping("/create-with-options")
    @Operation(summary = "CREATE QUESTION WITH OPTIONS", description = "CREATE QUESTION WITH OPTIONS")
    public void create(@RequestBody QuestionWithOptions question) {
        questionService.addQuestion(question);
    }
}
