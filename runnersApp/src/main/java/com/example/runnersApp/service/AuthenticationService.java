package com.example.runnersApp.service;

public interface AuthenticationService {
    boolean authenticate(String username, String password);
    void registerUser(String username, String password);
    void changePassword(String username, String oldPassword, String newPassword);
    String generateToken(String username);
    boolean validateToken(String token);
}