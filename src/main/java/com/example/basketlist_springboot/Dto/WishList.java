package com.example.basketlist_springboot.Dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import lombok.*;

/**
 * WISHLIST
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WishList extends WishListKey implements Serializable {
    private Integer wishProductNo;

    private Timestamp addedAt;

    private Product product;

    private static final long serialVersionUID = 1L;
}