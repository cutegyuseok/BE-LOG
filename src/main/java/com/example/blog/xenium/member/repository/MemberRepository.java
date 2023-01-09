package com.example.blog.xenium.member.repository;

import com.example.blog.mapper.xenium.MemberMapper;
import com.example.blog.xenium.member.dto.UpdateDTO;
import com.example.blog.xenium.member.dto.XenLoginDTO;
import com.example.blog.xenium.member.dto.Order;
import com.example.blog.xenium.member.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper memberMapper;

    public int signup(SignUpDTO dto){
        return memberMapper.signup(dto);
    }

    public SignUpDTO login(XenLoginDTO dto){
        return memberMapper.login(dto);
    }

    public int insertOrderBook(Order dto){
        return memberMapper.insertOrderBook(dto);
    }
    public int insertOrderDetail(HashMap<String,Object> map){
        return memberMapper.insertOrderDetail(map);
    }

    public int deleteCart(String id){
        return memberMapper.deleteCart(id);
    }

    public int autoSignup(String id){return memberMapper.autoSignup(id);}

    public int checkExist(String id){
        return memberMapper.checkExist(id);
    }

    public int changeInfo(UpdateDTO updateDTO){
        return memberMapper.changeInfo(updateDTO);
    }

    public SignUpDTO getUserInfo(String id){return memberMapper.getUserInfo(id);}


}
