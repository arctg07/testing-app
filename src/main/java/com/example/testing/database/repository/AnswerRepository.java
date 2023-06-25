package com.example.testing.database.repository;

import com.example.testing.database.entity.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Iurii Ivanov
 */

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    boolean existsByUserIdAndAndQuestionId(Long userId, Long questionId);
}
