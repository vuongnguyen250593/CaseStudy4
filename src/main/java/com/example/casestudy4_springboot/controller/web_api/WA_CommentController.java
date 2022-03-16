package com.example.casestudy4_springboot.controller.web_api;

import com.example.casestudy4_springboot.model.Comment;
import com.example.casestudy4_springboot.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class WA_CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/api/comment/{id}")
    public ResponseEntity<Iterable<Comment>> findByProduct(@PathVariable long id) {
        Iterable<Comment> comments = commentService.findCommentsByProduct(id);
        if (!comments.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/api/add-comment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment commentCreate = commentService.save(comment);
        return new ResponseEntity<>(commentCreate, HttpStatus.OK);
    }

//    @GetMapping("/comment/{id}")
//    public ResponseEntity<Optional<Comment>> findByProduct(@PathVariable long id) {
//        Optional<Comment> comments = commentService.findById(id);
//        if (!comments.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(comments, HttpStatus.OK);
//    }
}
