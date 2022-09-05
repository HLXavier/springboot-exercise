package com.pucrs.t1es2.services;

import org.springframework.stereotype.Service;

import com.pucrs.t1es2.dtos.requests.CreateUserDto;
import com.pucrs.t1es2.entity.User;
import com.pucrs.t1es2.mappers.UserMapper;
import com.pucrs.t1es2.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public void create(CreateUserDto dto) {
        User user = mapper.toUser(dto);
        repository.save(user);
    }

}
