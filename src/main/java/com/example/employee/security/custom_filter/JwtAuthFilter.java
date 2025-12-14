package com.example.employee.security.custom_filter;

import com.example.employee.security.auth_util.AuthUtil;
import com.example.employee.security.entity.User;
import com.example.employee.security.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private static final Logger LOGGER= LoggerFactory.getLogger(JwtAuthFilter.class);
    private final AuthUtil authUtil;
    private final UserRepository userRepository;

    public JwtAuthFilter(AuthUtil authUtil, UserRepository userRepository) {
        this.authUtil = authUtil;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LOGGER.info("Request Coming for {}:-"+request.getRequestURI());
        // Getting HEADER from the request
        String requestHeader = request.getHeader("Authorization");

        // Apply condition, If HEADER is NULL or HEADER NOT START with 'Bearer' then continue process
        // Because Format of Token:- Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBc2hyYWYiLCJ1c2VySWQiOiIyIiwiaWF0IjoxNzY1NzA5MzI2LCJleHAiOjE3NjU3MDk5MjZ9.i2c-bU1Qn4nmqA08B5VR1sqrlCG_2woCqtQXQvpCysXe7u9s542uy7MQhUg2mlHK6ttvq6YPbSYFjbvAtb6W3w
        if(requestHeader==null || !requestHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }

        // Getting TOKEN From HEADER
        // Format of Token:- Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBc2hyYWYiLCJ1c2VySWQiOiIyIiwiaWF0IjoxNzY1NzA5MzI2LCJleHAiOjE3NjU3MDk5MjZ9.i2c-bU1Qn4nmqA08B5VR1sqrlCG_2woCqtQXQvpCysXe7u9s542uy7MQhUg2mlHK6ttvq6YPbSYFjbvAtb6W3w
        // Index Position of 'Bearer' is 0 & TOKEN is 1 so Separate the Bearer & Token
        String token = requestHeader.split("Bearer ")[1];
        // Getting USER from the 'token'
        String username=authUtil.getUserFromToken(token);

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
            User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User Not Found:-" + username));
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(user,null,null);
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
       filterChain.doFilter(request,response);
    }
}
