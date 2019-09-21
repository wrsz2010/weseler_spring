package com.javadub1.weseler_spring.user;

import org.springframework.data.repository.CrudRepository;

public interface JpaUserRepository extends CrudRepository<User, Long> {

}
