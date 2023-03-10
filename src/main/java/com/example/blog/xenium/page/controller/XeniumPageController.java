package com.example.blog.xenium.page.controller;

import com.example.blog.aop.NonLogin;
import com.example.blog.xenium.member.dto.OrderList;
import com.example.blog.xenium.member.dto.SignUpDTO;
import com.example.blog.xenium.member.service.MemberService;
import com.example.blog.xenium.pocket.service.PocketService;
import com.example.blog.xenium.product.dto.ProductList;
import com.example.blog.xenium.product.service.ProductService;
import com.example.blog.xenium.util.dto.SearchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Api(tags = {"페이지 서비스"},description = "페이지 관련 서비스")
@RequestMapping("/xenium/*")
public class XeniumPageController {


    @Autowired
    ProductService ps;

    @Autowired
    PocketService pks;

    @Autowired
    MemberService memberService;

    @ApiOperation(value = "메인페이지", notes = "메인페이지(index) 이동")
    @GetMapping(value = {"/index",""})
    public String mainPage(HttpSession session) {
        session.setAttribute("categories",ps.getCategories());
        if (session.getAttribute("id")!=null){
            String id = String.valueOf(session.getAttribute("id"));
            if(!memberService.checkExist(id)){
                memberService.autoSignup(id);
            }
        }
        return "xenium/index";
    }

    @ApiOperation(value = "회원가입 페이지", notes = "회원가입 페이지 이동")
    @GetMapping("/signupPage")
    @NonLogin
    public String signupPage() {
        return "xenium/user/signup";
    }

    @ApiOperation(value = "사용자 로그인 페이지", notes = "사용자 로그인 페이지 이동")
    @GetMapping("/loginPage")
    @NonLogin
    public String loginPage() {
        return "login";
    }

    @ApiOperation(value = "가게정보 페이지", notes = "가게 정보 페이지 이동")
    @GetMapping("/aboutus")
    public String aboutus() {
        return "xenium/aboutus";
    }

    @ApiOperation(value = "상품 목록 페이지", notes = "상품 목록 페이지 이동")
    @GetMapping("/productList")
    public String productList(@RequestParam String searchWord, SearchDto params, Model model, HttpSession session) {
        params.setKeyword(searchWord);
        ProductList product = ps.findAll(params);
        model.addAttribute("product", product);
        String key=params.getKeyword();
        if(key!=null){
            model.addAttribute("keyword", params.getKeyword());
        }
        if(session.getAttribute("id")!=null){
            String id = String.valueOf(session.getAttribute("id"));
            model.addAttribute("paramText",pks.getUserCart(id));
        }
        return "xenium/productlist";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("GET방식으로 로그아웃");
        session.setAttribute("id",null);
        return "xenium/index";
    }

    @GetMapping("/changeInfo")
    public String changeInfo(){
        return "xenium/user/changeInfo";
    }

    @GetMapping("/orderList")
    public String orderList(Model model,HttpSession session){
        List<OrderList> list = memberService.selectOrderList(String.valueOf(session.getAttribute("id")));
        model.addAttribute("list",list);
        return "xenium/user/orderList";
    }
}
