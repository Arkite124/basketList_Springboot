package com.example.basketlist_springboot.Dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String userName;
    private String password;

    // 나중에 Security를 적용한다면 jwt 까지
    private UserDto user;
}
