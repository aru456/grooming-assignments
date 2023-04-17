package org.example.exception;

public class EmployeeTypeNotFound extends RuntimeException{
    public EmployeeTypeNotFound(String message) {
        super(message);
    }
}
