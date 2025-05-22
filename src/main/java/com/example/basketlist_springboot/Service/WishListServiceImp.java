package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.WishList;
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
        return List.of();
    }

    @Override
    public WishList AddWishList(WishList wishList) {
        return null;
    }

    @Override
    public void deleteWishList(Integer wishUserNo, Integer wishProductNo) {

    }

    @Override
    public void deleteWishListByWishUserNo(Integer wishUserNo) {

    }
}
