package com.devd.spring.SpringBootWithJWTAndAngular.repository;

import com.devd.spring.SpringBootWithJWTAndAngular.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-22 20:11
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
