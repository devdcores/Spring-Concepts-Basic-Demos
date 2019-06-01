package com.devd.spring.SpringBootWithJWTAndAngular.service;

import com.devd.spring.SpringBootWithJWTAndAngular.model.Book;
import com.devd.spring.SpringBootWithJWTAndAngular.model.User;

import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-22 20:00
 */
public interface GenericService {

    User findByUsername(String username);

    List<User> findAllUsers();

    List<Book> findAllBooks();
}
