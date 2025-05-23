package com.example.basketlist_springboot.Dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmPwDto {
    private String password;
    private String confirmPassword;
}
