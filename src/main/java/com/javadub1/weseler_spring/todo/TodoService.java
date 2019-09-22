package com.javadub1.weseler_spring.todo;

import com.javadub1.weseler_spring.user.exceptions.InvalidParameterException;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findByStatus(String status) {
        try {
            TodoStatus enumStatus = TodoStatus.valueOf(status);
            return todoRepository.findByStatus(enumStatus);
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException("status");
        }
    }

    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
