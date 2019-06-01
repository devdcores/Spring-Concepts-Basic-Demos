package com.devd.spring.SpringBootWithJWTAndAngular.service.impl;

import com.devd.spring.SpringBootWithJWTAndAngular.model.Book;
import com.devd.spring.SpringBootWithJWTAndAngular.model.User;
import com.devd.spring.SpringBootWithJWTAndAngular.repository.BooksRepository;
import com.devd.spring.SpringBootWithJWTAndAngular.repository.UserRepository;
import com.devd.spring.SpringBootWithJWTAndAngular.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-22 20:09
 */
@Service
public class GenericServiceImpl implements GenericService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public List<Book> findAllBooks() {
        return (List<Book>) booksRepository.findAll();
    }

}
