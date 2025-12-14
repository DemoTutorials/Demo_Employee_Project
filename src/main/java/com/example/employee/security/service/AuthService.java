package com.example.employee.security.service;

import com.example.employee.security.dto.LoginRequestDTO;
import com.example.employee.security.dto.LoginResponseDTO;
import com.example.employee.security.dto.SignUpRequestDTO;
import com.example.employee.security.dto.SignUpResponse;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
    SignUpResponse signup(SignUpRequestDTO signUpRequestDTO);
}
