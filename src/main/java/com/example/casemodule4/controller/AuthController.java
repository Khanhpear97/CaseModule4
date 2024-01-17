package com.example.casemodule4.controller;

import com.example.casemodule4.model.Users;
import com.example.casemodule4.service.IUserService;
import com.example.casemodule4.service.impl.UserService;
import com.example.casemodule4.userRegister.UserRegister;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthController {
    @Autowired
private UserService userService;

    @GetMapping("/login")
    public String showLogin(){
        return ("/login/index");
    }

    @GetMapping("/register")
    public ModelAndView showRegister(){
        Users user = new Users();
        ModelAndView modelAndView = new ModelAndView("/login/register");
        modelAndView.addObject("users", user);
        return modelAndView;
    }

//    @PostMapping("/register")
//    public String Register(@ModelAttribute UserRegister userRegister){
//        userService.register(userRegister);
//        return "redirect:/register";
//    }}

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute UserRegister userRegister,
                               BindingResult result,
                               Model model){
        Users existingUser = userService.findUserByEmail(userRegister.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userRegister);
            return "login/register";
        }

        userService.register(userRegister);
        return "redirect:/register?success";
    }
}
