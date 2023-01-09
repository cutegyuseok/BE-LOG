package com.example.blog.mapper.xenium;

import com.example.blog.xenium.member.dto.UpdateDTO;
import com.example.blog.xenium.member.dto.XenLoginDTO;
import com.example.blog.xenium.member.dto.Order;
import com.example.blog.xenium.member.dto.SignUpDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MemberMapper {

    public int signup(SignUpDTO dto);
    public SignUpDTO login(XenLoginDTO dto);

    public int insertOrderBook(Order order);

    public int insertOrderDetail(HashMap<String,Object> map);

    public int deleteCart(String id);

    public int autoSignup(String id);

    public int checkExist(String id);

    public int changeInfo(UpdateDTO updateDTO);

    public SignUpDTO getUserInfo(String id);
}
