package com.example.casestudy4_springboot.service;

import com.example.casestudy4_springboot.model.Like;

public interface ILikeService extends IGeneralService<Like> {
    Iterable<Like> findLikeByUser(long id);
}
