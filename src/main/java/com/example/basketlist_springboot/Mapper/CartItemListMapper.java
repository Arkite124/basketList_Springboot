package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.CartItemList;
import com.example.basketlist_springboot.Dto.CartItemListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartItemListMapper {
    int deleteByUserNo(Integer listUserNo); // 유저가 장바구니 목록 전체삭제
    int deleteByCartItemId(Integer cartItemId); //장바구니 목록 '한개'삭제
    int insert(CartItemListDto cartItemList); //장바구니 목록 등록
    Integer updateQuantity(Map<String,Integer> map); //수량 수정
    CartItemList selectByCartItemId(Integer cartItemId);
    List<CartItemList> selectByUserId(Integer ListUserNo);
    List<CartItemList> selectDetailByUserNo(Integer ListUserNo);
    Integer totalPrice(Integer userId); //진짜 총합 가격(쿼리 단에서 따로 구현)
    Integer selectedPrice(Map<String,Integer> map); //고른 상품의 수량*가격
    Integer checkItemDuplicate(Map<String,Integer> map); //이미 고른 상품이 있는지 확인
}