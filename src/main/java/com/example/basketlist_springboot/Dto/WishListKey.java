package com.example.basketlist_springboot.Dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.*;

/**
 * WISHLIST
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WishListKey implements Serializable {
    private Integer wishUserNo;

    private Integer wishProductNo;

    private static final long serialVersionUID = 1L;
}