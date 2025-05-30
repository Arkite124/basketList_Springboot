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
    void selectByProductIdAndProductCategory() {
        Map<String,Object> selectedProductMap=new HashMap<>();
        selectedProductMap.put("productId",22);
        selectedProductMap.put("productCategory","Fresh");
        Product selectedProduct = productMapper.selectByProductIdAndProductCategory(selectedProductMap);
        System.out.println(selectedProduct);
    }

    @Test
    @Transactional
    void selectByProductName() {
        Product product=productMapper.selectByProductName("신선한 당근");
        System.out.println(product);
    }

    @Test
    @Transactional
    void selectRandomThree() {
        List<Product> productList=productMapper.selectRandomThree();
        System.out.print(productList);
    }

    @Test
    @Transactional
    void selectByCategory() {
        int page=0;
        int size=4;
        Map<String,Object> map=new HashMap<>();
        Integer offset=page*size;
        map.put("category",null);
        map.put("offset",offset);
        map.put("size",size);
        List<Product> productList = productMapper.selectByCategory(map);
        System.out.println(productList);
    }

    @Test
    @Transactional
    void selectProductListLikeProductName() {
        int page=0;
        int size=4;
        String keyword="한";
        Map<String,Object> map=new HashMap<>();
        Integer offset=page*size;
        map.put("keyword",keyword);
        map.put("offset",offset);
        map.put("size",size);
        List<Product> productList = productMapper.selectProductListLikeProductName(map);
        System.out.println(productList);
    }

    @Test
    void deleteByProductIdAndProductUserNo() {
        Map<String,Integer> selectedProductMap=new HashMap<>();
        selectedProductMap.put("productId",70);
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
        System.out.println(productMapper.selectByProductName(product.getProductName()));
    }

    @Test
    @Transactional
    void selectProductListByProductUserNickname() {
        String productUserNickname="굿셀러";
        List<Product> productList = productMapper.selectProductListByProductUserNickname(productUserNickname);
        System.out.println(productList);
    }

    @Test
    @Transactional
    void countTotalProduct() {
        System.out.println(productMapper.CountTotalProduct(null));
    }
}