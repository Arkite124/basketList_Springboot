package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.CartItemList;
import com.example.basketlist_springboot.Dto.CartItemListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
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
        CartItemListDto cartItemList=cartItemListService.createCartItemList(9,64,3);
        System.out.println(cartItemList);
    }

    @Test
    void getCartItemList() {
        List<CartItemList> list=cartItemListService.getCartItemListDetail(8);
        System.out.println(list);
    }

    @Test
    void selectedCartItemPriceByUserIdAndCartItemId() {
    }

    @Test
    void totalCartPrice() {
    }

    @Test
    void checkCartItemDuplicate() {
    }
}