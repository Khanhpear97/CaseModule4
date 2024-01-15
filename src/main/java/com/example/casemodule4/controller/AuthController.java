package com.example.casemodule4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping()
public class AuthController {

    @GetMapping("/login")
    public String showLogin(){
        return ("/login/index");
    }
    @GetMapping("/home")
    public String showHome(){
        return "/login/home";
    }

}
