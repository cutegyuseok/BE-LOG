package com.example.blog.xenium.member.repository;

import com.example.blog.mapper.xenium.MemberMapper;
import com.example.blog.xenium.member.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

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

    public List<OrderList> selectOrderList(String id){
        return memberMapper.selectOrderList(id);
    }
    public List<EachProduct> selectEachProduct(String id){
        return memberMapper.selectEachProduct(id);
    }


}
