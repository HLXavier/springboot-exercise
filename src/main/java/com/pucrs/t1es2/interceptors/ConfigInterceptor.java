package com.pucrs.t1es2.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ConfigInterceptor implements WebMvcConfigurer {

    AuthInterceptor auth;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auth);
    }
}
