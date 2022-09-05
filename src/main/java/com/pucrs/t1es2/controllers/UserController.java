package com.pucrs.t1es2.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.t1es2.dtos.requests.CreateUserDto;
import com.pucrs.t1es2.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService service;

    @PostMapping
    public void create(@RequestBody CreateUserDto dto) {
        service.create(dto);
    }
}
