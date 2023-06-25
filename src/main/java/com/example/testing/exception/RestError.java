package com.example.testing.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Iurii Ivanov
 */

public record RestError(String code, HttpStatus httpStatus, String message) {
}