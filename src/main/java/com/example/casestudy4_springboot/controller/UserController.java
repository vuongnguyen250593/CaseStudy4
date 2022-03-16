package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.User;
import com.example.casestudy4_springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @ModelAttribute(value = "users")
    private Iterable<User> findAll() {
        return iUserService.findAll();
    }

    @GetMapping
    public ModelAndView showUser(Pageable pageable, @RequestParam Optional<String> search) {
         ModelAndView modelAndView = new ModelAndView("index");
         Page<User> users;
         if (search.isPresent()) {
             users = iUserService.findAllByEmail(search.get(), pageable);
             modelAndView.addObject("search", search.get());
         } else {
             users = iUserService.findAll(pageable);
         }
         modelAndView.addObject("users", users);
         return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(Pageable pageable, @PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("index");
        iUserService.deleteById(id);
        Page<User> users = iUserService.findAll(pageable);
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", new User());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "redirect:/create";
        }
        iUserService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit-user");
        Optional<User> user = iUserService.findOne(id);
        if (user.isPresent()){
            modelAndView.addObject("user", user);
        }
//        user.isPresent(value -> modelAndView.addObject("user", value));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String editUser(@Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult, Model model,
                           @PathVariable("id") Long id) throws Exception {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "edit";
        }
        iUserService.save(user);
        return "redirect:/edit";

    }


}
