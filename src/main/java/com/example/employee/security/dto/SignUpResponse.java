package com.example.employee.security.dto;

public class SignUpResponse {
    private Long userId;
    private String username;

    public SignUpResponse() {
    }

    public SignUpResponse(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SignUpResponse{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
