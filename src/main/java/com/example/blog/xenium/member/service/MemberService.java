package com.example.blog.xenium.member.service;

import com.example.blog.xenium.member.dto.UpdateDTO;
import com.example.blog.xenium.member.dto.XenLoginDTO;
import com.example.blog.xenium.member.dto.Order;
import com.example.blog.xenium.member.dto.SignUpDTO;
import com.example.blog.xenium.member.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public int signup(SignUpDTO dto) {
        try {
            return memberRepository.signup(dto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public SignUpDTO login(XenLoginDTO dto) {
        try {
            return memberRepository.login(dto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public boolean buy(Object pocket,SignUpDTO user){
        boolean success = true;
        Order order =new Order(user);
        memberRepository.insertOrderBook(order);
        int buyId= order.getPreid();
        Map<String, List<LinkedHashMap<String, String>>> param = (Map<String, List<LinkedHashMap<String, String>>>) pocket;
        List<LinkedHashMap<String, String>> cartList = param.get("pocket");
        for (LinkedHashMap<String,String> cart : cartList){
            HashMap<String,Object> map = new HashMap<>();
            map.put("id",buyId);
            map.put("userid",user.getId());
            map.put("pid",cart.get("id"));
            map.put("amount",cart.get("amount"));
            map.put("price",cart.get("price"));
            if(memberRepository.insertOrderDetail(map)<=0)success=false;
        }
        if (success){
            memberRepository.deleteCart(user.getId());
        }
        return success;
    }

    public boolean autoSignup(String id){
        try {
            System.out.println("auto Signup");
            if (memberRepository.autoSignup(id) > 0) {
                return true;
            } else {
               return false;
            }
        }catch (Exception e){
            logger.info(e.getMessage());
            return false;
        }
    }

    public boolean checkExist(String id){
        try {
            System.out.println(memberRepository.checkExist("check id"+id));
            if(memberRepository.checkExist(id)>0){
                return true;
            }else return false;
        }catch (Exception e){
            return false;
        }
    }

    public int changeInfo(UpdateDTO updateDTO){
        try {
            return memberRepository.changeInfo(updateDTO);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public SignUpDTO getUserInfo(String id){
        try {
            SignUpDTO signUpDTO = memberRepository.getUserInfo(id);
            return signUpDTO;
        }catch (Exception e){
            e.printStackTrace();
            return new SignUpDTO(id);
        }
    }

}
