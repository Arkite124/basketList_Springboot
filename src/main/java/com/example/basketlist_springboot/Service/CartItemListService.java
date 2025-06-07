package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.CartItemList;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public interface CartItemListService {
    CartItemList createCartItemList(int userId, int productNo, int quantity, LocalDate addedAt);
    List<CartItemList> getCartItemListDetail(int userId);
    Integer updateCartItemQuantity(int cartItemId, int quantity);
    void deleteCartItem(int cartItemId);
    void deleteAllCartItems(int userId);
    int selectedCartItemPriceByUserIdAndCartItemId(int userId,int cartItemId);
    int totalCartPrice (int userId);
}
