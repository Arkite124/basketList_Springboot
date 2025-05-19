package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {
    @Autowired
    ProductMapper productMapper;
    @Test
    @Transactional
    void selectByProductCategory() {
        List<Product> productList = productMapper.selectByProductCategory("alcohols");
        System.out.println(productList);
    }

    @Test
    @Transactional
    void selectByProductIdAndProductCategory() {
        Map<String,Object> selectedProductMap=new HashMap<>();
        selectedProductMap.put("productId",22);
        selectedProductMap.put("productCategory","Fresh");
        Product selectedProduct = productMapper.selectByProductIdAndProductCategory(selectedProductMap);
        System.out.println(selectedProduct);
    }

    @Test
    @Transactional
    void selectByProductId() {
        Product product=productMapper.selectByProductId(22);
        System.out.println(product);
    }

    @Test
    void selectAll() {
        List<Product> productList = productMapper.selectAll();
        System.out.print(productList);
    }
}