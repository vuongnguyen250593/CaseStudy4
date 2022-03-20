package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.User;
import com.example.casestudy4_springboot.repository.IUserRepository;
import com.example.casestudy4_springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService2 implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
