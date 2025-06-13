package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.WishListKey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishListServiceImpTest {
    @Autowired
    WishListService wishListService;
    @Test
    void getWishListStatus() {
        WishListKey wishListKey = new WishListKey();
        wishListKey.setWishProductNo(43);
        wishListKey.setWishUserNo(8);
        System.out.println(wishListService.getWishListStatus(wishListKey));
    }
}