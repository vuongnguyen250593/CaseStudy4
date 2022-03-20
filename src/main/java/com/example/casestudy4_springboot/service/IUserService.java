package com.example.casestudy4_springboot.service;

import com.example.casestudy4_springboot.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> getUserByEmail(String email);
}
