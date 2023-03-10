package com.example.blog.xenium.pocket.repository;

import com.example.blog.mapper.xenium.PocketMapper;
import com.example.blog.xenium.pocket.dto.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class PocketRepository {


    @Autowired
    PocketMapper pm;

    public List<HashMap<String,Object>> getUserCart(String userid){
        return pm.getUserCart(userid);
    }

    public Integer getProductOrderedAmount(String pId){
        return pm.getProductOrderedAmount(pId);
    }

    public int updateCart(Cart cart){
        return pm.updateCart(cart);
    }
    public int insertCart(Cart cart){
        return pm.insertCart(cart);
    }
    public int deleteCart(Cart cart){
        return pm.deleteCart(cart);
    }
}
