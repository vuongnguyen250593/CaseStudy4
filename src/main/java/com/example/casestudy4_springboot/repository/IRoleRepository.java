package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends PagingAndSortingRepository<Role, Long> {
}
