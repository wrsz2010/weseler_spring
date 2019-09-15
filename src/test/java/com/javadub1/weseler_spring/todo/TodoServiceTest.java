package com.javadub1.weseler_spring.todo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class TodoServiceTest {

    private TodoService todoService;

    @Before
    public void init(){
        this.todoService = new TodoService(new InMemoryTodoRepository(Arrays.asList(
                new Todo(1L, "name1", "zrobic zakupy", TodoStatus.NEW),
                new Todo(2L, "name2", "posprzatac", TodoStatus.DONE),
                new Todo(3L, "name3", "ugotowac obiad", TodoStatus.IN_PROGRESS),
                new Todo(4L, "name4", "wyniesc smieci", TodoStatus.DONE)
        )));
    }


    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldThrowExceptionWhenNull() {
        //given
        Long id = null;

        //when
        todoService.findById(id);
    }
    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldThrowExceptionWhenNegativeValue(){
        // given
        Long id = -1L;
        //when
        todoService.findById(id);
    }

    @Test
    public void findById_ShouldReturnOptionalWithExpectedUserForGivenId() {
        //given
        Long id = 3L;
        Todo expectedTodo = new Todo(3L, "name3", "ugotowac obiad", TodoStatus.IN_PROGRESS );

        //when
        Todo actual = todoService.findById(id);

        //then
        Assert.assertEquals(expectedTodo, actual);
    }

    @Test
    public void findByStatus() {

        //given
        TodoStatus status = TodoStatus.NEW;
        Todo expectedTodo = new Todo(1L, "name1", "zrobic zakupy", TodoStatus.NEW);
        //when
        List<Todo> actual = todoService.findByStatus(status);
        //then
        Assert.assertEquals("Optional was empty. User not found", 1,actual.size());
        Assert.assertEquals("Found user is not the correct one", expectedTodo, actual.get(0));
    }
}