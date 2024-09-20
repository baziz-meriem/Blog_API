package com.example.runnersApp.service;

import com.example.runnersApp.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Integer userId);
    User getUserById(Integer userId);
    List<User> getAllUsers();
    List<User> allUsers();
}