package com.example.casestudy4_springboot.controller.web_api;

import com.example.casestudy4_springboot.model.Like;
import com.example.casestudy4_springboot.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class WA_LikeController {

    @Autowired
    private ILikeService likeService;

    @GetMapping("/api/like/{id}")
    public ResponseEntity<Iterable<Like>> getLikeByUserId(@PathVariable long id) {
        Iterable<Like> likes = likeService.findLikeByUser(id);
        if (!likes.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @PostMapping("/api/like")
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        Like likeCreate = likeService.save(like);
        return new ResponseEntity<>(likeCreate, HttpStatus.OK);
    }

    @DeleteMapping("/api/like/{id}")
    public ResponseEntity<Optional<Like>> deleteLike(@PathVariable("id") long id) {
        Optional<Like> like = likeService.findById(id);
        if (!like.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        likeService.deleteById(id);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }
}