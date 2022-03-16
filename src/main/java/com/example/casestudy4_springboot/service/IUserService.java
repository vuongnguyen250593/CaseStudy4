package com.example.casestudy4_springboot.service;

import com.example.casestudy4_springboot.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {

    Page<User> findAllByEmail(String email, Pageable pageable);

    Page<User> findAll(Pageable pageable);

    Optional<User> findById(Long id);

    Optional<User> findOne(Long id);
//
//    void delete(Long id);
//
//    Page<User> searchUser(String name);
}
