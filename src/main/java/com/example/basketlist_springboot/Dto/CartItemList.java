package com.example.basketlist_springboot.Dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy년MM월dd일 a hh시mm분")
    private LocalDateTime addedAt;
    private Product products;

    private Integer selectedPrice;
    private Integer totalPrice;

    public CartItemList(CartItemList cartItemList) {
        this.cartItemId = cartItemList.getCartItemId();
        this.listUserNo = cartItemList.getListUserNo();
        this.quantity = cartItemList.getQuantity();
        this.addedAt = cartItemList.getAddedAt();
        this.products = cartItemList.getProducts();
        this.productNo = products.getProductId();
        this.selectedPrice = cartItemList.getSelectedPrice();
        this.totalPrice = cartItemList.getTotalPrice();
    }

    private static final long serialVersionUID = 1L;
}