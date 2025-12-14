package com.example.employee.security.service.impl;

import com.example.employee.security.auth_util.AuthUtil;
import com.example.employee.security.dto.LoginRequestDTO;
import com.example.employee.security.dto.LoginResponseDTO;
import com.example.employee.security.dto.SignUpRequestDTO;
import com.example.employee.security.dto.SignUpResponse;
import com.example.employee.security.entity.User;
import com.example.employee.security.repository.UserRepository;
import com.example.employee.security.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthenticationManager authenticationManager, AuthUtil authUtil, UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.authUtil = authUtil;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),loginRequestDTO.getPassword()));
       User user= (User) authenticate.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDTO(user.getId(),token);
    }

    @Override
    public SignUpResponse signup(SignUpRequestDTO signUpRequestDTO) {
        if(userRepository.findByUsername(signUpRequestDTO.getUsername()).isPresent()){
            throw new RuntimeException("User Already Present!...");
        }
        User user = modelMapper.map(signUpRequestDTO, User.class);
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        User newUser = userRepository.save(user);
        return modelMapper.map(newUser, SignUpResponse.class);
    }
}
