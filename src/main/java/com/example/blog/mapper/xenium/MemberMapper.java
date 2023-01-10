package com.example.blog.mapper.xenium;

import com.example.blog.xenium.member.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

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

    public List<OrderList> selectOrderList(String id);

    public List<EachProduct> selectEachProduct(String id);
}
