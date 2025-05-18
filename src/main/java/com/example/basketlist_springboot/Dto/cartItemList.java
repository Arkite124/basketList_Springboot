package com.example.basketlist_springboot.Dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.*;

/**
 * productList
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class cartItemList implements Serializable {
    private BigDecimal cartItemId;

    private BigDecimal productNo;

    private BigDecimal listUserNo;

    private BigDecimal quantity;

    private Date addedAt;

    private static final long serialVersionUID = 1L;
}