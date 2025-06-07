package com.example.basketlist_springboot.Dto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Boolean privacyAgreements;
    private Boolean marketingAgreements;
    private Timestamp createdAt;
    private Timestamp birthDate;
    private String name;
    public UserDetails(UserDetails userDetails) {
        this.detailUserNo = userDetails.getDetailUserNo();
        this.email = userDetails.getEmail();
        this.phone = userDetails.getPhone();
        this.privacyAgreements = userDetails.getPrivacyAgreements();
        this.marketingAgreements = userDetails.getMarketingAgreements();
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.birthDate = userDetails.getBirthDate();
        this.name = userDetails.getName();
    }

    private static final long serialVersionUID = 1L;
}