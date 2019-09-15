package com.javadub1.weseler_spring.todo;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(Long id) {
        super("Todo with id " + id + " not found");
    }
}
