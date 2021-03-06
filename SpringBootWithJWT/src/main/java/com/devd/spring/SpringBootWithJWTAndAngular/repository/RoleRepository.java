package com.devd.spring.SpringBootWithJWTAndAngular.repository;

import com.devd.spring.SpringBootWithJWTAndAngular.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-22 20:10
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
