package com.example.basketlist_springboot.Dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Integer userId;
    private String userName;
    private String password;
    private String profileImgUrl;
    private String userNickname;
    private String role;
    private String selfIntroduction;
    private String email;
    private String phone;
    private Boolean privacyAgreements;
    private Boolean marketingAgreements;
    private Timestamp createdAt;
    private Timestamp birthDate;
    private String name;
//종합 정보 조회
private static final long serialVersionUID = 1L;
}
