package com.javadub1.weseler_spring.todo;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private List<Todo> todos;

    public InMemoryTodoRepository() {
        this.todos = new ArrayList<>();
    }

    // package protected typowo pod testy
    InMemoryTodoRepository(List<Todo> todos){
        this.todos = new ArrayList<>(todos);
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todos);
    }

    @Override
    public Optional<Todo> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException();
        }
        return todos.stream()
                .filter(todo -> id.equals(todo.getId()))
                .findFirst();
    }

    @Override
    public List<Todo> findByStatus(TodoStatus status) {
        return todos.stream()
                .filter(todo -> status.equals(todo.getStatus()))
                .collect(Collectors.toList());
    }
}
