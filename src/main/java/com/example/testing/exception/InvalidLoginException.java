package com.example.testing.exception;

/**
 * @author Iurii Ivanov
 */

public class InvalidLoginException extends RuntimeException {

    public InvalidLoginException(String login) {
        super(String.format("User: '%s' already exist.", login));
    }

}
