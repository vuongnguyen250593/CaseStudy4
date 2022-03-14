package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Like;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepository extends PagingAndSortingRepository<Like, Long> {
}
