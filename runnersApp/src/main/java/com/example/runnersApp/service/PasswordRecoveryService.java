package com.example.runnersApp.service;

public interface PasswordRecoveryService {
    void initiateRecovery(String email);
    boolean verifyRecoveryToken(String token);
    void resetPassword(String token, String newPassword);
}