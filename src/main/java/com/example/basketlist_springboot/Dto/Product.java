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

    private Users users;

    private static final long serialVersionUID = 1L;
}