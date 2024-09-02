package com.example.runnersApp.service.impl;

import com.example.runnersApp.model.User;
import com.example.runnersApp.repository.UserRepo;
import com.example.runnersApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepo.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}