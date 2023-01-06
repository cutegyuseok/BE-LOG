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
        System.out.println(obj.toString());
       Map<String ,LinkedHashMap<String,HashMap<String,Object>>> param = (Map<String, LinkedHashMap<String,HashMap<String,Object>>>) obj;
       LinkedHashMap<String,HashMap<String, Object>> info = param.get("authObj");
        System.out.println(info);
        String id = String.valueOf(info.get("id"));
        HashMap<String,Object> kakaoAccount = info.get("kakao_account");
        String nickName = ((HashMap<String, String>) kakaoAccount.get("profile")).get("nickname");
        String email = String.valueOf(kakaoAccount.get("email"));
        try {
            if (loginRepository.existsById(id)) {
                session.setAttribute("SESSION_NAME",id);
                loginRepository.save(Login.builder().id(id).name(nickName).email(email).build());
                return nickName;
            } else {
                session.setAttribute("SESSION_NAME",id);
                loginRepository.save(Login.builder().id(id).name(nickName).email(email).build());
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

    public String signOut(){
        String id=String.valueOf(session.getAttribute("SESSION_NAME"));
        try {
            loginRepository.deleteById(id);
            session.setAttribute("SESSION_NAME",null);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }

    }
}
