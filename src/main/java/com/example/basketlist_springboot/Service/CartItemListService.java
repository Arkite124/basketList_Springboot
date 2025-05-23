package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.CartItemList;

import java.sql.Timestamp;
import java.util.List;

public interface CartItemListService {
    CartItemList createCartItemList(int userId, int productNo, int quantity, Timestamp addedAt);
    List<CartItemList> getCartItemList(int userId);
    Integer updateCartItemQuantity(int cartItemId, int quantity);
    void deleteCartItem(int cartItemId);
    void deleteAllCartItems(int userId);
    int selectedCartItemPriceByUserIdAndCartItemId(int userId,int cartItemId);
    int totalCartPrice (int userId);
}
