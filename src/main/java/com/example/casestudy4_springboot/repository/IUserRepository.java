package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
    User findByEmail(String email);
    User findUserByName(String name);
    Optional<User> findUserByEmail(String email);
}
