package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.CartItemList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
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
    @Transactional
    void totalPrice() {
        System.out.println(cartItemListMapper.totalPrice(9));
    }

    @Test
    @Transactional
    void selectedPrice() {
        Map<String,Integer> map = new HashMap<>();
        map.put("listUserNo",9);
        map.put("cartItemId",20);
        Integer UserSelectedPrice=cartItemListMapper.selectedPrice(map);
        System.out.println(UserSelectedPrice);
    }

    @Test
    void selectByUserId() {
        List<CartItemList> cartItemList=cartItemListMapper.selectByUserId(9);
        System.out.println(cartItemList);
    }

    @Test
    void updateQuantity() {
        Map<String,Integer> map = new HashMap<>();
        map.put("quantity",3);
        map.put("cartItemId",20);
        cartItemListMapper.updateQuantity(map);
        System.out.println(cartItemListMapper.selectByCartItemId(20));
    }

    @Test
    void deleteByUserNo() {
        System.out.println(cartItemListMapper.deleteByUserNo(9));
    }
}