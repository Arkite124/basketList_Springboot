package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.CartItemList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartItemListServiceImpTest {
    @Autowired
    CartItemListService cartItemListService;

    @Test
    void updateCartItemQuantity() {
        Integer updateQuantity=cartItemListService.updateCartItemQuantity(20,5);
        System.out.println(updateQuantity);
    }

    @Test
    @Transactional
    void createCartItemList() {
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        CartItemList cartItemList=cartItemListService.createCartItemList(9,53,3,timestamp);
        System.out.println(cartItemList);
    }

    @Test
    void getCartItemList() {
    }

    @Test
    void selectedCartItemPriceByUserIdAndCartItemId() {
    }

    @Test
    void totalCartPrice() {
    }
}