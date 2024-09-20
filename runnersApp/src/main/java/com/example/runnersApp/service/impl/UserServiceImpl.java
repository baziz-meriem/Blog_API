package com.example.runnersApp.service.impl;

import com.example.runnersApp.model.User;
import com.example.runnersApp.repository.UserRepo;
import com.example.runnersApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService , UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }
    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;
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


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            return userRepo.findByEmail(email)
                    .orElseThrow(() ->
                            new UsernameNotFoundException(
                                    String.format(USER_NOT_FOUND_MSG, email)));

    }
}