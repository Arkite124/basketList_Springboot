package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.CartItemList;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Mapper.CartItemListMapper;
import com.example.basketlist_springboot.Mapper.UsersMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CartItemListServiceImp implements CartItemListService {
    private final CartItemListMapper cartItemListMapper;
    private final UsersMapper usersMapper;

    @Override
    public CartItemList createCartItemList(int userId, int productNo, int quantity, LocalDate addedAt) {
        Users user=usersMapper.selectByUserId(userId);
        if(user.getRole().equals("seller")){
            return null;
        }
        CartItemList cartItemList = new CartItemList();
        cartItemList.setListUserNo(userId);
        cartItemList.setProductNo(productNo);
        cartItemList.setQuantity(quantity);
        cartItemList.setAddedAt(Timestamp.valueOf(addedAt.atStartOfDay()));
        cartItemListMapper.insert(cartItemList);
        return cartItemList;
    }

    @Override
    public List<CartItemList> getCartItemListDetail(int userId) {
        List<CartItemList> cartItemLists=cartItemListMapper.selectDetailByUserNo(userId);
        return cartItemLists;
    }

    @Override
    public Integer updateCartItemQuantity(int cartItemId, int quantity) {
        Map<String,Integer> map=new HashMap<>();
        map.put("cartItemId",cartItemId);
        map.put("quantity",quantity);
        return cartItemListMapper.updateQuantity(map);
    }

    @Override
    public void deleteCartItem(int cartItemId) {
        cartItemListMapper.deleteByCartItemId(cartItemId);
    }

    @Override
    public void deleteAllCartItems(int userId) {
        cartItemListMapper.deleteByUserNo(userId);
    }

    @Override
    public int selectedCartItemPriceByUserIdAndCartItemId(int userId, int cartItemId) {
        //쉽게 말하면 고른 물품의 수량*가격
        Map<String,Integer> map=new HashMap<>();
        map.put("listUserNo",userId);
        map.put("cartItemId",cartItemId);
        return cartItemListMapper.selectedPrice(map);
    }

    @Override
    public int totalCartPrice(int userId) {
        return cartItemListMapper.totalPrice(userId);
    }
}
