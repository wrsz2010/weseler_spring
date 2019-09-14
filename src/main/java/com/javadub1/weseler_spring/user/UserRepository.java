package com.javadub1.weseler_spring.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

   Optional<User> findById(Long id);
   List<User> findAll();
}
