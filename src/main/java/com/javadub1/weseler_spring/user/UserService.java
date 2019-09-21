package com.javadub1.weseler_spring.user;

import com.javadub1.weseler_spring.user.exceptions.InvalidParameterException;
import com.javadub1.weseler_spring.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private UserRepository userRepository;

    public UserService(@Qualifier("inMemoryUserRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByGender(String gender) {
        try {
            Gender enumGender = Gender.valueOf(gender);
            return userRepository.findByGender(enumGender);
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException("gender");
        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
