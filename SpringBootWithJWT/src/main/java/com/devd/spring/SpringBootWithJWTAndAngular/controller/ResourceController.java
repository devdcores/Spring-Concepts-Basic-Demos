package com.devd.spring.SpringBootWithJWTAndAngular.controller;

import com.devd.spring.SpringBootWithJWTAndAngular.model.Book;
import com.devd.spring.SpringBootWithJWTAndAngular.model.User;
import com.devd.spring.SpringBootWithJWTAndAngular.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-22 19:58
 */
@RestController
@RequestMapping("/api")
public class ResourceController {

    @Autowired
    private GenericService userService;

    @RequestMapping(value ="/books")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<Book> getUser(){
        return userService.findAllBooks();
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

}
