package com.example.blog.service;

import com.example.blog.dto.LoginDTO;
import com.example.blog.entity.Login;
import com.example.blog.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    HttpSession session;
    @Autowired
    LoginRepository loginRepository;

    public String login(Object obj){
       Map<String ,LinkedHashMap<String,HashMap<String,Object>>> param = (Map<String, LinkedHashMap<String,HashMap<String,Object>>>) obj;
       LinkedHashMap<String,HashMap<String, Object>> info = param.get("authObj");
        System.out.println(info);
        HashMap<String,Object> kakaoAccount = info.get("kakao_account");
        String nickName = ((HashMap<String, String>) kakaoAccount.get("profile")).get("nickname");
        String email = String.valueOf(kakaoAccount.get("email"));
        try {
            if (loginRepository.existsByEmail(email)) {
                session.setAttribute("SESSION_NAME",nickName);
                return nickName;
            } else {
                loginRepository.save(new Login(email, nickName));
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    public String logout(){
        session.setAttribute("SESSION_NAME",null);
        return "success";
    }
}
