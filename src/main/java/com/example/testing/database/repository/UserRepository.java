package com.example.testing.database.repository;

import com.example.testing.database.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Iurii Ivanov
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByLogin(String login);
    Optional<User> findByLogin(String login);
}
