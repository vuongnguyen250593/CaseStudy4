package com.example.casestudy4_springboot.controller.web_api;

import com.example.casestudy4_springboot.model.User;
import com.example.casestudy4_springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@SessionAttributes("userInformation")
public class WA_UserLogin {

    @Autowired
    private IUserService userService;

    @GetMapping("/user-information")
    public ResponseEntity<Optional<User>> userInformation(HttpSession session) {
        Optional<User> user = (Optional<User>) session.getAttribute("userInformation");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/username")
    public ResponseEntity<Optional<User>> loginUser(@RequestParam("username") String email, HttpSession session) {
        Optional<User> user = userService.getUserByEmail(email);
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        session.setAttribute("userInformation", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
