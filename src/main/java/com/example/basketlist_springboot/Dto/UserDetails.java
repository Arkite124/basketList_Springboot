package com.example.basketlist_springboot.Dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.*;

/**
 * userDetails
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails implements Serializable {
    private Integer detailUserNo;

    private String email;

    private String phone;

    private Short privacyAgreements;

    private Short marketingAgreements;

    private Date createdAt;

    private Date birthDate;

    private String name;

    private static final long serialVersionUID = 1L;
}