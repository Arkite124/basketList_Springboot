package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.cartItemList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface cartItemListMapper {
    int deleteByCartItemId(Integer cartItemId); //장바구니 목록 초기화
    int insert(cartItemList record); //장바구니 목록 기록
    cartItemList selectByPrimaryKey(Integer cartItemId);
    int updateByPrimaryKeySelective(cartItemList record);
    int updateByPrimaryKey(cartItemList record);
}