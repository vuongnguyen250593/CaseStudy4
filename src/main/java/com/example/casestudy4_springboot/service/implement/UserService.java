package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Role;
import com.example.casestudy4_springboot.repository.IUserRepository;
import com.example.casestudy4_springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService, IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.casestudy4_springboot.model.User user = iUserRepository.findByEmail(username);
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(user.getRole());
        return new User(user.getEmail(), user.getPassword(), roles);
    }

    @Override
    public com.example.casestudy4_springboot.model.User getUserByName(String name) {
        return iUserRepository.findUserByName(name);
    }

    @Override
    public Optional<com.example.casestudy4_springboot.model.User> getUserByEmail(String email) {
        return iUserRepository.findUserByEmail(email);
    }
}