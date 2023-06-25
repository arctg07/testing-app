package com.example.testing.database.repository;

import com.example.testing.database.entity.User;
import com.example.testing.model.Statistic;
import com.example.testing.model.UserStatistics;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Iurii Ivanov
 */

public interface StatisticRepository extends CrudRepository<User, Long> {

    @Query("SELECT " +
            "(SELECT COUNT(*) FROM users) AS total_users, " +
            "COUNT(DISTINCT CASE WHEN a.correct_answers = q.total_questions THEN a.user_id END) AS passed_users, " +
            "COUNT(DISTINCT CASE WHEN a.answered_questions = q.total_questions THEN a.user_id END) AS answered_all_questions, " +
            "COUNT(DISTINCT CASE WHEN a.correct_answers = q.total_questions THEN a.user_id END) AS answered_all_questions_correctly " +
            "FROM " +
            "users u " +
            "LEFT JOIN ( " +
            "SELECT " +
            "a.user_id, " +
            "COUNT(CASE WHEN a.result = TRUE THEN 1 END) AS correct_answers, " +
            "COUNT(DISTINCT a.question_id) AS answered_questions " +
            "FROM " +
            "answers a " +
            "GROUP BY " +
            "a.user_id " +
            ") a ON u.id = a.user_id " +
            "CROSS JOIN ( " +
            "SELECT " +
            "COUNT(*) AS total_questions " +
            "FROM " +
            "questions " +
            ") q " +
            "GROUP BY " +
            "q.total_questions")
    Statistic getFullStatistics();

    @Query("WITH current_user_stats AS (\n" +
            "    SELECT user_id,\n" +
            "        COUNT(CASE WHEN result = TRUE THEN 1 END) AS correct_answers\n" +
            "    FROM\n" +
            "        answers\n" +
            "    WHERE\n" +
            "            user_id = :userId -- Замените :userId на идентификатор текущего пользователя\n" +
            "    GROUP BY\n" +
            "        user_id\n" +
            "),\n" +
            "     all_users_stats AS (\n" +
            "         SELECT\n" +
            "             user_id,\n" +
            "             COUNT(CASE WHEN result = TRUE THEN 1 END) AS correct_answers\n" +
            "         FROM\n" +
            "             answers\n" +
            "         GROUP BY\n" +
            "             user_id\n" +
            "     )\n" +
            "SELECT\n" +
            "            (SELECT correct_answers FROM current_user_stats) * 100.0 / COUNT(*) AS current_user_percentage,\n" +
            "            (COUNT(*) - COUNT(CASE WHEN correct_answers > (SELECT correct_answers FROM current_user_stats) THEN 1 END)) * 100.0 / COUNT(*) AS worse_users_percentage,\n" +
            "            COUNT(CASE WHEN correct_answers > (SELECT correct_answers FROM current_user_stats) THEN 1 END) * 100.0 / COUNT(*) AS better_users_percentage\n" +
            "FROM\n" +
            "    all_users_stats")
    UserStatistics getUserStatistics(@Param("userId") Long userId);


}
