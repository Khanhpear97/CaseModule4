package com.example.casemodule4.controller;

import com.example.casemodule4.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLogin(){
        return ("/login/index");
    }
    @GetMapping("/test")
    public String showTest(){
        return ("/login/test");
    }
    @GetMapping("/home")
    public String showHome(){
        return ("/login/home");
    }
    @GetMapping("/register")
    public ModelAndView showRegister(){
        Users user = new Users();
        ModelAndView modelAndView = new ModelAndView("/login/register");
        modelAndView.addObject("users", user);
        return modelAndView;
    }

}
