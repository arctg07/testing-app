package com.example.testing.database.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Iurii Ivanov
 */

@Data
@Builder
@Table("answers")
public class Answer {
    @Id
    Long id;

    Long userId;

    Long questionId;

    String answer;

    Boolean result;
}
