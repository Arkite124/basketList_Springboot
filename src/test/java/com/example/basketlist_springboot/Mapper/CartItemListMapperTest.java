package com.example.basketlist_springboot.Mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CartItemListMapperTest {
    @Autowired
    CartItemListMapper cartItemListMapper;

    @Test
    void deleteByCartItemId() {
    }

    @Test
    void insert() {
    }

    @Test
    void selectByCartItemId() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }

    @Test
    void totalPrice() {
    }

    @Test
    @Transactional
    void selectedPrice() {
        Map<String,Integer> map = new HashMap<>();
        map.put("cartItemId",20);
        map.put("listUserNo",9);
        Integer UserSelectedPrice=cartItemListMapper.selectedPrice(map);
        System.out.println(UserSelectedPrice);
    }
}