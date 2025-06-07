package com.example.basketlist_springboot.Dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private Integer productId;
    private String productCategory;
    private String productName;
    private String productImgUrl;
    private String productDescription;
    private Integer productUserNo;
    private Integer productPrice;
    private Integer productQuantity;
    private Timestamp productAddedAt;

    private Integer totalCount;
    private Users users;


    public Product(Product product) {
        this.productId = product.getProductId();
        this.productCategory = product.getProductCategory();
        this.productName = product.getProductName();
        this.productImgUrl = product.getProductImgUrl();
        this.productDescription = product.getProductDescription();
        this.productUserNo = product.getProductUserNo();
        this.productPrice = product.getProductPrice();
        this.productQuantity = product.getProductQuantity();
        this.productAddedAt = product.getProductAddedAt();
        this.totalCount = product.getTotalCount();
        this.users = product.getUsers();
    }

    private static final long serialVersionUID = 1L;
}