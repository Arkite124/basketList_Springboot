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
@NoArgsConstructor
public class Users implements Serializable {
    private Integer userId;
    private String userName;
    private String profileImgUrl;
    private String userNickname;
    private String role;
    private UserDetails userDetails;

    private static final long serialVersionUID = 1L;
}