package com.pucrs.t1es2.services;

import org.springframework.stereotype.Service;

import com.pucrs.t1es2.dtos.requests.CreateUserDto;
import com.pucrs.t1es2.dtos.requests.LoginDto;
import com.pucrs.t1es2.entities.User;
import com.pucrs.t1es2.mappers.UserMapper;
import com.pucrs.t1es2.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final AuthService authService;
    private final UserMapper mapper;

    public void create(CreateUserDto dto) {
        User user = mapper.toUser(dto);
        repository.save(user);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email)
            .orElseThrow(RuntimeException::new);
    }

    public String login(LoginDto dto) {
        User user = findByEmail(dto.getEmail());

        if (user.getPassword().equals(dto.getPassword())) {
            return authService.authorize();
        }

        throw new RuntimeException();
    }

}
