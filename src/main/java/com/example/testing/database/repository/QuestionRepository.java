package com.example.testing.database.repository;

import com.example.testing.database.entity.Question;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Iurii Ivanov
 */

public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Query("SELECT * FROM questions WHERE id NOT IN (SELECT question_id FROM answers " +
            "WHERE user_id = :userId) ORDER BY random() LIMIT 1")
    Optional<Question>  getTestQuestion(@Param("userId") Long userId);
}
