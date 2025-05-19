package com.example.basketlist_springboot.Dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer userId;
    private String userName;
    private String profileImgUrl;
    private String userNickname;
    private String role;
    private String email;
    private String phone;
    private Short privacyAgreements;
    private Short marketingAgreements;
    private Date createdAt;
    private Date birthDate;
    private String name;
//종합 정보 입력 및 조회
}
