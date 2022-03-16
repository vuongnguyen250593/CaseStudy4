package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepository extends JpaRepository<Like, Long> {
    Iterable<Like> findLikesByUser_Id (long id);
}
