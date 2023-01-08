package com.example.blog.main.controller;

import com.example.blog.aop.Login;
import com.example.blog.aop.NonLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/index")
    public String index1(){
        return "index";
    }

    @GetMapping("/generic")
    public String generic(){
        return "generic";
    }

    @GetMapping("/elements")
    public String elements(){
        return "elements";
    }

    @NonLogin
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
