package com.javadub1.weseler_spring.user;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryUserRepository implements UserRepository{

    private List<User> users;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
    }

    // package protected typowo pod testy
    InMemoryUserRepository(List<User> users){
        this.users = users;
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException();
        }
        return users.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @PostConstruct
    public void init(){
        this.users.add(new User(1L, "Szymon", "Nowak",Gender.MALE));
        this.users.add(new User(2L, "Karolina", "Nowak", Gender.FEMALE));
        this.users.add(new User(3L, "Szymon", "Kowalski", Gender.MALE));
        this.users.add(new User(4L, "Jan", "Mcclowsky",Gender.MALE));
    }
}
