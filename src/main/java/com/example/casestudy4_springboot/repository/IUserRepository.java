package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {

    Page<User> findAllByEmail(String email, Pageable pageable);
}
