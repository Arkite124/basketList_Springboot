package com.example.basketlist_springboot.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

// 해당 유저가 판매하는 판매목록을 조회하기 위함
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserAndProductDto {
    private Integer userId;
    private String profileImgUrl;
    private String userNickname;
    private String selfIntroduction;
    private String role;
    private Product product;
    private Integer productId;
    private String productCategory;
    private String productName;
    private String productImgUrl;
    private Integer productUserNo;
    private String productDescription;
    private Integer productPrice;
    private Integer productQuantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy년MM월dd일")
    private LocalDate productAddedAt;
}
