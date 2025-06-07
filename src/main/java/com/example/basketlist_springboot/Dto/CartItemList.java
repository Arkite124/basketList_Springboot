package com.example.basketlist_springboot.Dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import lombok.*;

/**
 * productList
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartItemList implements Serializable {
    private Integer cartItemId;
    private Integer productNo;
    private Integer listUserNo;
    private Integer quantity;
    private Timestamp addedAt;
    private Product products;

    private Integer selectedPrice;
    private Integer totalPrice;

    public CartItemList(CartItemList cartItemList) {
        this.cartItemId = cartItemList.getCartItemId();
        this.productNo = cartItemList.getProductNo();
        this.listUserNo = cartItemList.getListUserNo();
        this.quantity = cartItemList.getQuantity();
        this.addedAt = cartItemList.getAddedAt();
        this.products = cartItemList.getProducts();
        this.selectedPrice = cartItemList.getSelectedPrice();
        this.totalPrice = cartItemList.getTotalPrice();
    }

    private static final long serialVersionUID = 1L;
}