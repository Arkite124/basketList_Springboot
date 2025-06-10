package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.WishList;
import com.example.basketlist_springboot.Dto.WishListKey;
import com.example.basketlist_springboot.Mapper.WishListMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WishListServiceImp implements WishListService {
    private final WishListMapper wishListMapper;

    @Override
    public List<WishList> getWishListByWishUserNo(Integer wishUserNo) {
        return wishListMapper.selectAllByWishUserNo(wishUserNo);
    }

    @Override
    public Integer AddWishList(Integer wishUserNo, Integer wishProductNo) {
        WishList wishList = new WishList();
        wishList.setWishUserNo(wishUserNo);
        if(wishUserNo==null || wishProductNo==null){
            return null;
        }
        wishList.setWishProductNo(wishProductNo);
        return wishListMapper.insert(wishList);
    }

    @Override
    public Integer deleteWishList(Integer wishUserNo, Integer wishProductNo) {
        WishListKey wishListKey = new WishListKey();
        wishListKey.setWishUserNo(wishUserNo);
        wishListKey.setWishProductNo(wishProductNo);
        WishList wishList = wishListMapper.selectWishListByKey(wishListKey);
        if(wishList==null){
            throw new Error("삭제되었거나 없는 위시리스트입니다.");
        }
       return wishListMapper.deleteByWishListKey(wishListKey);
    }

    @Override
    public Integer deleteWishListByWishUserNo(Integer wishUserNo) {
        if(wishUserNo==null){
            return null;
        }
        return wishListMapper.deleteByWishUserNo(wishUserNo);
    }
}
