package com.example.casemodule4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class AuthController {

    @GetMapping()
    public ModelAndView showLogin(){
        return new ModelAndView("/login/index");
    }


}
