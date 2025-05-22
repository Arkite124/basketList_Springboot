package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.Product;
import com.sun.jdi.CharType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @Test
    @Transactional
    void selectByCategory() {
        List<Product> productList = productMapper.selectByCategory("Fresh");
        System.out.println(productList);
    }

    @Test
    void selectProductListLikeProductName() {
        List<Product> productList = productMapper.selectProductListLikeProductName("한");
        System.out.println(productList);
    }

    @Test
    void selectProductListByProductUserNo() {
        List<Product> productList= productMapper.selectProductListByProductUserNo(1);
        System.out.println(productList);
    }

    @Test
    void deleteByProductIdAndProductUserNo() {
        Map<String,Integer> selectedProductMap=new HashMap<>();
        selectedProductMap.put("productId",86);
        selectedProductMap.put("productUserNo",1);
        assertEquals(1, productMapper.deleteByProductIdAndProductUserNo(selectedProductMap));
    }

    @Test
    void insertProduct() {
        Product product=new Product();
        product.setProductCategory("Fresh");
        product.setProductName("단감 1box");
        product.setProductImgUrl(null);
        product.setProductDescription("싱싱한 단감 입니다.");
        product.setProductPrice(19000);
        product.setProductUserNo(1);
        product.setProductQuantity(100);
        productMapper.insertProduct(product);
        System.out.println(productMapper.selectByProductId(product.getProductId()));
    }
}