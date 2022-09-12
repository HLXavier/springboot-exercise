package com.pucrs.t1es2.mappers;

import org.springframework.stereotype.Component;

import com.pucrs.t1es2.dtos.requests.CreateUserDto;
import com.pucrs.t1es2.entities.User;

@Component
public class UserMapper {

    public User toUser(CreateUserDto dto) {
        return User.builder()
            .name(dto.getName())
            .email(dto.getEmail())
            .password(dto.getPassword())
            .build();
    }

}
