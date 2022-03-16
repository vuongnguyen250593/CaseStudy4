package com.example.casestudy4_springboot.service;

import com.example.casestudy4_springboot.model.Comment;

public interface ICommentService extends IGeneralService<Comment>{
    Iterable<Comment> findCommentsByProduct(long id);
}
