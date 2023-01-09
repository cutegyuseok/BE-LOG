package com.example.blog.xenium.pocket.controller;

import com.example.blog.xenium.member.dto.SignUpDTO;
import com.example.blog.xenium.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/xenium/*")
public class PocketController {

    @Autowired
    PocketService pocketService;

    @RequestMapping("/addCart")
    public @ResponseBody String addCart(@RequestBody(required = false) Object pocket, HttpSession session) {
        if (session.getAttribute("id")==null)return "loginFail";
        String id = String.valueOf(session.getAttribute("id"));
        pocketService.updateCartInDB(pocket,id);
        return "success";
    }
    @PostMapping("/selectAvailAmountCart")//상품id로 최대 구매 가능수량 확인
    public String selectAvailAmountCart(String id) {
    String fragment = String.valueOf(pocketService.selectAvailAmountCart(id));
        return fragment;
    }

    @PostMapping("/deleteCart")
    public String deleteCart(String id,@ApiIgnore HttpSession session){
        String uid = String.valueOf(session.getAttribute("id"));
        if(pocketService.deleteCart(id,uid)){
            return "success";
        }
        return "failed";
    }
}
