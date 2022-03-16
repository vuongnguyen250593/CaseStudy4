package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
