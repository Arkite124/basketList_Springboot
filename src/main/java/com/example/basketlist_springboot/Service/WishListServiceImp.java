package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.WishList;
import com.example.basketlist_springboot.Dto.WishListKey;
import com.example.basketlist_springboot.Mapper.WishListMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    public Integer addWishList(WishList wishList) {
        if(wishList.getWishUserNo()==null || wishList.getWishProductNo()==null){
           throw new Error("위시리스트에 등록할 수 없습니다.");
        }
        wishList.setWishUserNo(wishList.getWishUserNo());
        wishList.setWishProductNo(wishList.getWishProductNo());
        wishList.setAddedAt(Timestamp.valueOf(LocalDateTime.now()));
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
