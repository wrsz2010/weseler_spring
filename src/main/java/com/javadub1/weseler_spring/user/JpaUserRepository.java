package com.javadub1.weseler_spring.user;

import com.javadub1.weseler_spring.user.entities.Gender;
import com.javadub1.weseler_spring.user.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaUserRepository extends CrudRepository<User, Long> {
    List<User> findByGender(Gender gender);
}
