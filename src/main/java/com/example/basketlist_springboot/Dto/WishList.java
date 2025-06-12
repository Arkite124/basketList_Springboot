package com.example.basketlist_springboot.Dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer wishUserNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy년MM월dd일")
    private Timestamp addedAt;
    private Product product;
    public WishList(WishList wishList, Product product) {
        this.wishUserNo = wishList.getWishUserNo();
        this.wishProductNo = product.getProductId();
        this.product = product;
    }

    private static final long serialVersionUID = 1L;
}