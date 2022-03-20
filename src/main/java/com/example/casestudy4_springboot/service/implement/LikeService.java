package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Like;
import com.example.casestudy4_springboot.repository.ILikeRepository;
import com.example.casestudy4_springboot.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService implements ILikeService {

    @Autowired
    private ILikeRepository likeRepository;

    @Override
    public Iterable<Like> findAll() {
        return likeRepository.findAll();
    }

    @Override
    public Optional<Like> findById(long id) {
        return likeRepository.findById(id);
    }

    @Override
    public Like save(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public void deleteById(long id) {
        likeRepository.deleteById(id);
    }

    @Override
    public Iterable<Like> findLikeByUser(long id) {
        return likeRepository.findLikesByUser_Id(id);
    }

    @Override
    public Optional<Like> findLikeByProductAndUser(long product, long user) {
        return likeRepository.findLikeByProductAndUser(product, user);
    }

    @Override
    public Like save1ByProductAndUser(long product, long user) {
        return likeRepository.save1ByProductAndUser(product, user);
    }

    @Override
    public Like save2ByProductAndUser(long product, long user) {
        return likeRepository.save2ByProductAndUser(product, user);
    }
}
