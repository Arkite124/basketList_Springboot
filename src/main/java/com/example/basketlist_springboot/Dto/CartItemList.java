package com.example.basketlist_springboot.Dto;

import java.io.Serializable;
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

    private Date addedAt;

    private Integer selectedPrice;
    private Integer totalPrice;

    private static final long serialVersionUID = 1L;
}