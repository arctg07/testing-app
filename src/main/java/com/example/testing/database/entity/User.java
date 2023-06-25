package com.example.testing.database.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Iurii Ivanov
 */

@Data
@Table("users")
public class User {

    @Id
    private Long id;

    private String login;

    private String password;
}
