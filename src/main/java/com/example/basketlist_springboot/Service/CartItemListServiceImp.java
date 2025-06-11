package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.CartItemList;
import com.example.basketlist_springboot.Dto.CartItemListDto;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Mapper.CartItemListMapper;
import com.example.basketlist_springboot.Mapper.UsersMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CartItemListServiceImp implements CartItemListService {
    private final CartItemListMapper cartItemListMapper;
    private final UsersMapper usersMapper;

    @Override
    public CartItemListDto createCartItemList(int userId, int productNo, int quantity) {
        Users user=usersMapper.selectByUserId(userId);
        if(user.getRole().equals("seller")){
            return null;
        }
        CartItemListDto cartItemListDto = new CartItemListDto();
        cartItemListDto.setListUserNo(userId);
        cartItemListDto.setProductNo(productNo);
        cartItemListDto.setQuantity(quantity);
        cartItemListDto.setAddedAt(Timestamp.valueOf(LocalDateTime.now()));
        cartItemListMapper.insert(cartItemListDto);
        return cartItemListDto;
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
    public Integer checkCartItemDuplicate(int productNo, int userId) {
        Map<String,Integer> map=new HashMap<>();
        map.put("listUserNo",userId);
        map.put("productNo",productNo);
        return cartItemListMapper.checkItemDuplicate(map);
    }//장바구니에 중복상품이 담기면 안됨

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
