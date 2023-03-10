package com.example.blog.xenium.product.repository;

import com.example.blog.mapper.xenium.ProductMapper;
import com.example.blog.xenium.product.dto.Category;
import com.example.blog.xenium.product.dto.Product;
import com.example.blog.xenium.util.dto.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepository {


    @Autowired
    ProductMapper productMapper;

    public List<Product> selectProduct(SearchDto dto){
        return productMapper.selectProduct(dto);
    }

    public int selectAllCount(){
        return productMapper.selectAllCount();
    }

    public List<Product> selectDistinctProduct(SearchDto dto){
        return productMapper.selectDistinctProduct(dto);
    }

    public int selectDistinctCount(SearchDto dto){
        return productMapper.selectDistinctCount(dto);
    }

    public List<Category>getCategories(){
        return productMapper.getCategories();
    }

    public int getProductAmount(String pId){
        return productMapper.getProductAmount(pId);
    }
    public List<HashMap<String, Object>> checkAvailProductId(){
        return productMapper.checkAvailProductId();
    }


}
