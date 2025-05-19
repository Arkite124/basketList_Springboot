package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.CartItemList;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface CartItemListMapper {
    int deleteByCartItemId(Integer cartItemId); //장바구니 목록 초기화
    int insert(CartItemList record); //장바구니 목록 기록
    CartItemList selectByCartItemId(Integer cartItemId);
    int updateByPrimaryKeySelective(CartItemList record);
    int updateByPrimaryKey(CartItemList record);
    Integer totalPrice(CartItemList record);
    Integer selectedPrice(Map<String,Integer> map);
}