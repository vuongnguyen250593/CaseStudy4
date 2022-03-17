package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Comment;
import com.example.casestudy4_springboot.repository.ICommentRepository;
import com.example.casestudy4_springboot.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Iterable<Comment> findCommentsByProduct(long id) {
        return commentRepository.findCommentsByProduct_Id(id);
    }

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }
}