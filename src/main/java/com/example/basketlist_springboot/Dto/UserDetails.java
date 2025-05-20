package com.example.basketlist_springboot.Dto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
    private Timestamp createdAt;
    private Timestamp birthDate;
    private String name;

    private static final long serialVersionUID = 1L;
}