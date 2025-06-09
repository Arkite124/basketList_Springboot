package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.CartItemList;
import com.example.basketlist_springboot.Dto.CartItemListDto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public interface CartItemListService {
    CartItemListDto createCartItemList(int userId, int productNo, int quantity);
    List<CartItemList> getCartItemListDetail(int userId);
    Integer updateCartItemQuantity(int cartItemId, int quantity);
    void deleteCartItem(int cartItemId);
    void deleteAllCartItems(int userId);
    Integer checkCartItemDuplicate(int productNo,int userId);
    int selectedCartItemPriceByUserIdAndCartItemId(int userId, int cartItemId);
    int totalCartPrice (int userId);
    Integer updateCartItemPrice(int cartItemId, int price);
}
