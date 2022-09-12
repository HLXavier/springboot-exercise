package com.pucrs.t1es2.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

    List<String> authorizations = new ArrayList<>();

    public String authorize() {
        String token = RandomStringUtils.randomAlphanumeric(10);
        authorizations.add(token);
        return token;
    }

    public boolean isAuthorized(String authorization) {
        return authorizations.stream()
            .anyMatch(auth -> auth.equals(authorization));
    }

}
