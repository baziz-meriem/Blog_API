package com.example.runnersApp.controller;

import com.example.runnersApp.service.PasswordRecoveryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password-recovery")
public class PasswordRecoveryController {
    PasswordRecoveryService passwordRecoveryService;
}
