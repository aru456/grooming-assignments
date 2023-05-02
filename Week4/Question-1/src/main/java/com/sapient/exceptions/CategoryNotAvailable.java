package com.sapient.exceptions;

public class CategoryNotAvailable extends RuntimeException{
    public CategoryNotAvailable(String message) {
        super(message);
    }
}
