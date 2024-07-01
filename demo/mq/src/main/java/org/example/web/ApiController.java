package org.example.web;//package com.example.demo.mq.web;

import org.example.entity.Users;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<Users> users() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Users user(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }
}