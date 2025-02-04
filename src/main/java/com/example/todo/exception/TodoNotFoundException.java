package com.example.todo.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String content) {
        super(content);
    }
}
