package com.example.testing.exception;

/**
 * @author Iurii Ivanov
 */

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException() {
        super("The username or password you entered is incorrect");
    }
}
