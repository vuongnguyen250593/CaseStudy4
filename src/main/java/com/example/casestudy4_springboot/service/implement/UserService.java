package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.User;
import com.example.casestudy4_springboot.repository.IUserRepository;
import com.example.casestudy4_springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<User> findAllByEmail(String email, Pageable pageable){
        return iUserRepository.findAllByEmail(email, pageable);
    }

    @Override
    public Optional<User> findOne(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return (Page<User>) iUserRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        iUserRepository.deleteById(id);
    }
}

