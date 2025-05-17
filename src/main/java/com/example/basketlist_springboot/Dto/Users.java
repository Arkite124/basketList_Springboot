package com.example.basketlist_springboot.Dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.*;

/**
 * users
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Users implements Serializable {
    private BigDecimal userId;

    private String userName;

    private String profileImgUrl;

    private String userNickname;

    private String role;

    private static final long serialVersionUID = 1L;
}