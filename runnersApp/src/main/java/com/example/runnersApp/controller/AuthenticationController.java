package com.example.runnersApp.controller;

import com.example.runnersApp.service.AuthenticationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    AuthenticationService authenticationService;
}
