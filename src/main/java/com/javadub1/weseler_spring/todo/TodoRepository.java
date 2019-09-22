package com.javadub1.weseler_spring.todo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findByStatus(TodoStatus status);
}
