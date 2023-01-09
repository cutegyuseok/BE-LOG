package com.example.blog.xenium.member.controller;

import com.example.blog.xenium.member.dto.SignUpDTO;
import com.example.blog.xenium.member.service.MemberService;
import com.example.blog.xenium.pocket.service.PocketService;
import com.example.blog.xenium.product.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/xenium/*")
@Api(tags = {"사용자 서비스"},description = "사용자 관련 서비스")
public class MemberController {

    @Autowired
    ProductService productService;
    @Autowired
    PocketService pocketService;

    @Autowired
    MemberService memberService;
    @PostMapping("/confirmBuying")
    public String confirmBuying(@RequestBody(required = false) Object pocket, @ApiIgnore HttpSession session){
        if (session.getAttribute("id")==null)return "loginFail";
        String id = String.valueOf(session.getAttribute("id"));
        if (productService.checkAvailProductId(pocket,pocketService.getUserCart(id))){
            return "success";
        }
        return "notAvail";
    }

    @PostMapping("/confirmRest")
    public String confirmRest(@RequestBody(required = false) Object pocket, HttpSession session){
        if(memberService.buy(pocket,memberService.getUserInfo(String.valueOf(session.getAttribute("id"))))){
            return "success";
        }
        return "failed";
    }


}
