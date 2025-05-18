package com.example.basketlist_springboot.Dao;

import com.example.basketlist_springboot.Dto.cartItemList;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductListDao {
    int deleteByCartItemId(BigDecimal cartItemId); //장바구니 목록 초기화
    int insert(cartItemList record); //장바구니 목록 기록
    int insertSelective(cartItemList record); // 수량, 유저,
    cartItemList selectByPrimaryKey(BigDecimal cartItemId);
    int updateByPrimaryKeySelective(cartItemList record);
    int updateByPrimaryKey(cartItemList record);
}