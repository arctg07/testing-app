package com.example.testing.controller;

import com.example.testing.exception.InvalidCredentialsException;
import com.example.testing.exception.InvalidLoginException;
import com.example.testing.exception.NotFoundException;
import com.example.testing.exception.RestError;
import com.example.testing.exception.TestingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author Iurii Ivanov
 */

@RestControllerAdvice
public class ApiHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<RestError> handleClientNotFoundException(Exception ex) {
        RestError restError = new RestError("validation_failed", NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(restError, NOT_FOUND);
    }

    @ExceptionHandler(InvalidLoginException.class)
    public ResponseEntity<RestError> handleInvalidLoginException(Exception ex) {
        RestError restError = new RestError("invalid_login", CONFLICT, ex.getMessage());
        return new ResponseEntity<>(restError, CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestError> handleNotFoundException(Exception ex) {
        RestError restError = new RestError("not_found", NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(restError, NOT_FOUND);
    }

    @ExceptionHandler(TestingException.class)
    public ResponseEntity<RestError> handleTestingException(Exception ex) {
        RestError restError = new RestError("testing_exception", CONFLICT, ex.getMessage());
        return new ResponseEntity<>(restError, CONFLICT);
    }
}
