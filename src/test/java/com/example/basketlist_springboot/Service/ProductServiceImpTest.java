package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.Product;
import com.example.basketlist_springboot.Mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImpTest {
    @Autowired
    private ProductService productService;

    @Test
    void getProductPageByCategory() {
        Page<Product> productPages = productService.getProductPageByCategory("Fresh",0,4);
        System.out.println(productPages.getContent());
    }

    @Test
    void getProductByProductNo() {
        Product selectedProduct = productService.getProductByProductNo(4);
        System.out.println(selectedProduct);
    }

    @Test
    void getProductListByUserId() {
        List<Product> productList = productService.getProductListByUserId(2);
        System.out.println(productList);
    }
}