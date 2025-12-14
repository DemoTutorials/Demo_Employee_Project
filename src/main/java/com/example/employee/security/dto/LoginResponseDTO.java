package com.example.employee.security.dto;

public class LoginResponseDTO {
    private long userId;
    private String jwtToken;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(long userId, String jwtToken) {
        this.userId = userId;
        this.jwtToken = jwtToken;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "userId=" + userId +
                ", jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
