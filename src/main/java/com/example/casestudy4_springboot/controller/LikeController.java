package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.CartDetail;
import com.example.casestudy4_springboot.model.Like;
import com.example.casestudy4_springboot.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LikeController {

    @Autowired
    private ILikeService likeService;

    @GetMapping("/favourite/{id}")
    public ModelAndView showLike(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("user-favourite");
        Iterable<Like> likes = likeService.findLikeByUser(id);
        if (!likes.iterator().hasNext()) {
            modelAndView.addObject("likes", null);
        } else {
            modelAndView.addObject("likes", likes);
        }
        return modelAndView;
    }
}