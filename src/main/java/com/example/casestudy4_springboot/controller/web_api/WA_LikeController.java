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
@RequestMapping("/user/api")
public class WA_LikeController {

    @Autowired
    private ILikeService likeService;

    @GetMapping("/like-product/{idP}/{idU}")
    public ResponseEntity<Optional<Like>> getLikeByProductAndUser(@PathVariable("idP") long idP,
                                                                  @PathVariable("idU") long idU) {
        Optional<Like> like = likeService.findLikeByProductAndUser(idP, idU);
        if (!like.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    @GetMapping("/like/{id}")
    public ResponseEntity<Iterable<Like>> getLikeByUserId(@PathVariable long id) {
        Iterable<Like> likes = likeService.findLikeByUser(id);
        if (!likes.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @PostMapping("/like/{idP}/{idU}")
    public ResponseEntity<?> createLike(@RequestBody Like like,
                                           @PathVariable("idP") long idP,
                                           @PathVariable("idU") long idU) {
        Optional<Like> likeFind = likeService.findLikeByProductAndUser(idP, idU);
        if (likeFind.isPresent()) {
            return new ResponseEntity<>(likeFind,HttpStatus.OK);
        }
        Like likePost = likeService.save(like);
        return new ResponseEntity<>(likePost, HttpStatus.OK);
    }

    @PutMapping("/like/{idP}/{idU}")
    public ResponseEntity<Like> editLike(@RequestBody Like like,
                                           @PathVariable("idP") long idP,
                                           @PathVariable("idU") long idU) {
        Optional<Like> likeFind = likeService.findLikeByProductAndUser(idP, idU);
        if (!likeFind.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        like.setId(likeFind.get().getId());
        Like likePost = likeService.save(like);
        return new ResponseEntity<>(likePost, HttpStatus.OK);
    }

    @DeleteMapping("/like/{idP}/{idU}")
    public ResponseEntity<Optional<Like>> deleteLike(@PathVariable("idP") long idP,
                                                     @PathVariable("idU") long idU) {
        Optional<Like> like = likeService.findLikeByProductAndUser(idP, idU);
        if (!like.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        likeService.deleteById(like.get().getId());
        return new ResponseEntity<>(like, HttpStatus.OK);
    }
}
