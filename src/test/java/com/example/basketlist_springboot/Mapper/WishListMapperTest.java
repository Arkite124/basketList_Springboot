package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.WishList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishListMapperTest {
    @Autowired
    WishListMapper wishListMapper;

    @Test
    void selectAllByWishUserNo() {
        List<WishList> wishLists = wishListMapper.selectAllByWishUserNo(1);
        System.out.println(wishLists);
    }
}