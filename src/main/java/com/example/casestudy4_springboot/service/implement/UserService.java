package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Role;
import com.example.casestudy4_springboot.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.casestudy4_springboot.model.User user = iUserRepository.findByEmail(username);
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(user.getRole());
        return new User(user.getEmail(), user.getPassword(), roles);
    }
}