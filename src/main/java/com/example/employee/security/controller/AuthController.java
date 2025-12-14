package com.example.employee.security.controller;

import com.example.employee.security.dto.LoginRequestDTO;
import com.example.employee.security.dto.LoginResponseDTO;
import com.example.employee.security.dto.SignUpRequestDTO;
import com.example.employee.security.dto.SignUpResponse;
import com.example.employee.security.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequestDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(@RequestBody SignUpRequestDTO signUpRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(authService.signup(signUpRequestDTO));
    }


}
