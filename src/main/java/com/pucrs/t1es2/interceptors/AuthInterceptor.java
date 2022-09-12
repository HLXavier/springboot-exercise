package com.pucrs.t1es2.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.pucrs.t1es2.annotations.NoAuth;
import com.pucrs.t1es2.services.AuthService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
        throws Exception {

        NoAuth noAuth = ((HandlerMethod)handler).getMethod().getAnnotation((NoAuth.class));

        if (noAuth == null) {
            String authorization = request.getHeader("Authorization");

            if (!authService.isAuthorized(authorization)) {
                response.setStatus(401);
                return false;
            }
        }

        return true;
    }
}
