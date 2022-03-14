package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
