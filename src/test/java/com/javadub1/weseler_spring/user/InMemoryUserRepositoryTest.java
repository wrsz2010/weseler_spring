package com.javadub1.weseler_spring.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

public class InMemoryUserRepositoryTest {

    private InMemoryUserRepository inMemoryUserRepository;

    @Before
    public void init(){
        this.inMemoryUserRepository = new InMemoryUserRepository(Arrays.asList(
                new User(1L, "Szymon", "Nowak", Gender.MALE),
                new User(2L, "Karolina", "Nowak", Gender.FEMALE),
                new User(3L, "Jan", "Kowalski", Gender.MALE),
                new User(4L, "Piotr", "Panek", Gender.MALE)
        ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldThrowIllegalArgumentExceptionWhenPassingNull() {
        //GIVEN
        Long id = null;

        //WHEN
        inMemoryUserRepository.findById(id);
    }
    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldThrowIllegalArgumentExceptionWhenPassingNegativeValue() {
        //GIVEN
        Long id = -2L;

        //WHEN
        inMemoryUserRepository.findById(id);
    }
    @Test
    public void findById_ShouldReturnEmptyOptionalForNonExistingId() {
        //given
        Long id = 5L;
        User expectedUser = new User(3L, "Jan", "Kowalski", Gender.MALE);

        //when
        Optional<User> actual = inMemoryUserRepository.findById(id);

        //then
        Assert.assertFalse("Optional is not empty. User has found", actual.isPresent());
    }
    @Test
    public void findById_ShouldReturnOptionalWithExpectedUserForGivenId() {
        //given
        Long id = 3L;
        User expectedUser = new User(3L, "Jan", "Kowalski", Gender.MALE);

        //when
        Optional<User> actual = inMemoryUserRepository.findById(id);

        //then
        Assert.assertTrue("Optional was empty. User not found", actual.isPresent());
        Assert.assertEquals("Found user is not the correct one", expectedUser, actual.get());
    }
}