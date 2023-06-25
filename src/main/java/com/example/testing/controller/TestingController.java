package com.example.testing.controller;

import com.example.testing.model.AnswerRequest;
import com.example.testing.model.TestQuestion;
import com.example.testing.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Iurii Ivanov
 */

@RestController
@RequestMapping("/testing/test")
@Tag(name = "Testing controller", description = "API for work with test-service")
@RequiredArgsConstructor
public class TestingController {

    private final TestService testService;

    @GetMapping("/question/{userId}")
    @Operation(summary = "GET QUESTION", description = "GET QUESTION")
    public TestQuestion getQuestion(@PathVariable String userId) {
        return testService.getQuestion(userId);
    }

    @PostMapping("/answer/{userId}")
    @Operation(summary = "ANSWER THE QUESTION", description = "ANSWER THE QUESTION")
    public ResponseEntity<String> answer(@PathVariable String userId,
                                         @RequestBody AnswerRequest answerRequest) {
        String result = testService.answer(userId, answerRequest);
        return ResponseEntity.ok(result);
    }
}
