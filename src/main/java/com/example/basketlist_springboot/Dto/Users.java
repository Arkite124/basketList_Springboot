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
    private String password;
    private String profileImgUrl;
    private String userNickname;
    private String selfIntroduction;
    private String role;
    private UserDetails userDetails;

    public Users(Users users) {
        this.userId = users.getUserId();
        this.userName = users.getUserName();
        this.password = users.getPassword();
        this.profileImgUrl = users.getProfileImgUrl();
        this.userNickname = users.getUserNickname();
        this.selfIntroduction = users.getSelfIntroduction();
        this.role = users.getRole();
        this.userDetails = users.getUserDetails();
    }

    private static final long serialVersionUID = 1L;
}