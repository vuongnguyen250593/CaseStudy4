package com.example.casestudy4_springboot.service;

import com.example.casestudy4_springboot.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User getUserByName(String name);
    Optional<User> getUserByEmail(String email);
}
