package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.product.id = :id ORDER BY c.id DESC")
    Iterable<Comment> findCommentsByProduct_Id(long id);
}
