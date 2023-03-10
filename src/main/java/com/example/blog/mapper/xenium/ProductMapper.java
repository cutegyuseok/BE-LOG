package com.example.blog.mapper.xenium;

import com.example.blog.xenium.product.dto.Category;
import com.example.blog.xenium.product.dto.Product;
import com.example.blog.xenium.util.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductMapper {

    public List<Product> selectProduct(SearchDto dto);
    public int selectAllCount();

    public List<Product> selectDistinctProduct(SearchDto dto);

    public int selectDistinctCount(SearchDto dto);

    public List<Category>getCategories();

    public int getProductAmount(String pId);


    List<HashMap<String, Object>> checkAvailProductId();

}
