package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
}
