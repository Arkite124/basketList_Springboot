package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.WishList;
import com.example.basketlist_springboot.Dto.WishListKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WishListMapper {
    int deleteByPrimaryKey(WishListKey key);

    int insert(WishList record);

    WishList selectWishListByKey(WishListKey key);

    List<WishList> selectAllByWishUserNo(Integer wishUserNo);
}