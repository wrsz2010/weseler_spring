package com.javadub1.weseler_spring.todo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class InMemoryTodoRepositoryTest {

    private InMemoryTodoRepository inMemoryTodoRepository;

    @Before
    public void init(){
        this.inMemoryTodoRepository = new InMemoryTodoRepository(Arrays.asList(
                new Todo(1L, "name1", "zrobic zakupy", TodoStatus.NEW),
                new Todo(2L, "name2", "posprzatac", TodoStatus.DONE),
                new Todo(3L, "name3", "ugotowac obiad", TodoStatus.IN_PROGRESS),
                new Todo(4L, "name4", "wyniesc smieci", TodoStatus.DONE)
        ));
    }


    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldThrowExceptionWhenNull() {
        //given
        Long id = null;

        //when
        inMemoryTodoRepository.findById(id);
    }
    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldThrowExceptionWhenNegativeValue(){
        // given
        Long id = -1L;
        //when
        inMemoryTodoRepository.findById(id);
    }
    @Test
    public void findById_ShouldReturnEmptyOptionalWhenNoId(){
        //given
        Long id = 5L;
        Todo expectedUser = new Todo(3L, "name3", "ugotowac obiad", TodoStatus.IN_PROGRESS);

        //when
        Optional<Todo> actual = inMemoryTodoRepository.findById(id);

        //then
        Assert.assertFalse("Optional is not empty. User has found", actual.isPresent());
    }
    @Test
    public void findById_ShouldReturnOptionalWithExpectedUserForGivenId() {
        //given
        Long id = 3L;
        Todo expectedTodo = new Todo(3L, "name3", "ugotowac obiad", TodoStatus.IN_PROGRESS );

        //when
        Optional<Todo> actual = inMemoryTodoRepository.findById(id);

        //then
        Assert.assertTrue("Optional was empty. User not found", actual.isPresent());
        Assert.assertEquals("Found user is not the correct one", expectedTodo, actual.get());
    }

    @Test
    public void findByStatus() {

        //given
        TodoStatus status = TodoStatus.IN_PROGRESS;
        Todo expectedTodo = new Todo(3L, "name3", "ugotowac obiad", TodoStatus.IN_PROGRESS );
        //when
        List<Todo> actual = inMemoryTodoRepository.findByStatus(status);
        //then
        Assert.assertTrue("User was not found", actual.size()==1);
        Assert.assertEquals("Found user is not the correct one", expectedTodo, actual.get(0));
    }
}