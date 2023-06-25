package com.example.testing.exception;

/**
 * exception: incorrect account information
 *
 * @author Iurii Ivanov
 */

public class NotFoundException extends RuntimeException{

    public <T> NotFoundException(Class<T> entityType, String id) {
        super(String.format("Not found %s with: %s.", entityType.getSimpleName(), id));
    }
}
