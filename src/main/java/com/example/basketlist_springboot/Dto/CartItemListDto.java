package com.example.basketlist_springboot.Dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * productList
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartItemListDto implements Serializable {
    private Integer cartItemId;
    private Integer productNo;
    private Integer listUserNo;
    private Integer quantity;
    private Timestamp addedAt;

    public CartItemListDto(CartItemListDto cartItemList,Product product) {
        this.cartItemId = cartItemList.getCartItemId();
        this.listUserNo = cartItemList.getListUserNo();
        this.quantity = cartItemList.getQuantity();
        this.addedAt = cartItemList.getAddedAt();
        this.productNo = product.getProductId();
    }

    private static final long serialVersionUID = 1L;
}