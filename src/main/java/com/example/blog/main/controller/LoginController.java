package com.example.blog.main.controller;

import com.example.blog.main.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("login")
    public String login(@RequestBody(required = false) Object obj){
        return loginService.login(obj);
    }

    @PostMapping("logout")
    public String logout(){
        return loginService.logout();
    }

    @PostMapping("signOut")
    public String signOut(){
        return loginService.signOut();
    }
}
