package com.example.casestudy4_springboot.service;

import com.example.casestudy4_springboot.model.Like;

import java.util.Optional;

public interface ILikeService extends IGeneralService<Like> {
    Iterable<Like> findLikeByUser(long id);

    Optional<Like> findLikeByProductAndUser(long product, long user);

    Like save1ByProductAndUser(long product, long user);

    Like save2ByProductAndUser(long product, long user);
}
