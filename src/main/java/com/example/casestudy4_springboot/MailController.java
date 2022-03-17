package com.example.casestudy4_springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    JavaMailSender javaMailSender;

    @RequestMapping
    public String showForm(){
        return "/FormSendMail";
    }

    @RequestMapping("/send")
    public String sendMail(@RequestParam("to")String to,
                            @RequestParam("from")String from,
                           @RequestParam("subject")String subject,
                           @RequestParam("content")String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom(from);
        msg.setSubject(subject);
        msg.setSubject(subject);
        msg.setText(content);
        javaMailSender.send(msg);
        return "result";

    }
}
