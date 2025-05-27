package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
class ProductServiceImpTest {
    @Autowired
    private ProductService productService;

    @Test
    void getProductPageByCategory() {
        Page<Product> productPages = productService.getProductPageByCategory("Fresh",1,4);
        System.out.println(productPages.getContent());
    }

    @Test
    void getProductByProductName() {
        Product selectedProduct = productService.getProductByProductName("김 튀각");
        System.out.println(selectedProduct);
    }

    @Test
    void searchProductsByKeyWord() {

    }

    @Test
    void getRandomThree() {
        System.out.println(productService.getRandomThree());

    }

//    @Test
//    void getProductListByUserId() {
//        List<Product> productList = productService.getProductListByUserId(2);
//        System.out.println(productList);
//    }
}