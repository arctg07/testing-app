package com.example.testing.database.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


/**
 * @author Iurii Ivanov
 */

@Data
@Table("questions")
public class Question {

    @Id
    private Long id;
    private String question;
    private String correctAnswer;
    private String answerOptions;
}
