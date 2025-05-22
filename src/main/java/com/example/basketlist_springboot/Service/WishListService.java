package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.WishList;

import java.util.List;

public interface WishListService {
    List<WishList> getWishListByWishUserNo(Integer wishUserNo);
    WishList AddWishList(WishList wishList);
    void deleteWishList(Integer wishUserNo,Integer wishProductNo); //위시리스트 전부 삭제
    void deleteWishListByWishUserNo(Integer wishUserNo);
}
