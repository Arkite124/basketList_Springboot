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
public class Userdetails implements Serializable {
    private BigDecimal detailUserNo;

    private String email;

    private String phone;

    private Short privacyAgreements;

    private Short marketingAgreements;

    private Date createdAt;

    private Date birthDate;

    private String name;

    private static final long serialVersionUID = 1L;
}