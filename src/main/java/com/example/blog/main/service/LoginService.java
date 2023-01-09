package com.example.blog.main.service;

import com.example.blog.main.entity.Login;
import com.example.blog.main.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
        String id = String.valueOf(info.get("id"));
        HashMap<String,Object> kakaoAccount = info.get("kakao_account");
        String nickName = ((HashMap<String, String>) kakaoAccount.get("profile")).get("nickname");
        String email = String.valueOf(kakaoAccount.get("email"));
        try {
            if (loginRepository.existsById(id)) {
                session.setAttribute("id",id);
                loginRepository.save(Login.builder().id(id).name(nickName).email(email).build());
                return nickName;
            } else {
                session.setAttribute("id",id);
                loginRepository.save(Login.builder().id(id).name(nickName).email(email).build());
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    public String logout(){
        session.setAttribute("id",null);
        return "success";
    }

    public String signOut(){
        String id=String.valueOf(session.getAttribute("id"));
        try {
            loginRepository.deleteById(id);
            session.setAttribute("id",null);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }

    }
}
