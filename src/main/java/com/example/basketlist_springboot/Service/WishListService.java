package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.WishList;

import java.util.List;

public interface WishListService {
    List<WishList> getWishListByWishUserNo(Integer wishUserNo); //전부 조회(하나만 조회할 일은 없음)
    Integer addWishList(WishList wishList); //위시리스트 추가
    Integer deleteWishList(Integer wishUserNo,Integer wishProductNo); //위시리스트 하나 삭제
    Integer deleteWishListByWishUserNo(Integer wishUserNo); // 해당 사용자의 위시리스트 전부 삭제
    //업데이트는 필요 없음 애초에 추가/삭제만 하면 되는 거니까
}
