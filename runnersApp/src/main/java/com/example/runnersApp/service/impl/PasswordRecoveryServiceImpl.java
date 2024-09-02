package com.example.runnersApp.service.impl;

import com.example.runnersApp.service.PasswordRecoveryService;
import org.springframework.stereotype.Service;

@Service
public class PasswordRecoveryServiceImpl implements PasswordRecoveryService {

    @Override
    public void initiateRecovery(String email) {
        // Implement logic to initiate password recovery
    }

    @Override
    public boolean verifyRecoveryToken(String token) {
        // Implement logic to verify recovery token
        return false;
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        // Implement logic to reset password
    }
}