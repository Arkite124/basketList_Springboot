package com.example.basketlist_springboot.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String name;
//종합 정보 조회
    public UserDto(UserDto userDto) {
        this.userId = userDto.getUserId();
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
        this.profileImgUrl = userDto.getProfileImgUrl();
        this.userNickname = userDto.getUserNickname();
        this.role = userDto.getRole();
        this.selfIntroduction = userDto.getSelfIntroduction();
        this.email = userDto.getEmail();
        this.phone = userDto.getPhone();
        this.privacyAgreements = userDto.getPrivacyAgreements();
        this.marketingAgreements = userDto.getMarketingAgreements();
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.birthDate = userDto.getBirthDate();
        this.name = userDto.getName();
    }
private static final long serialVersionUID = 1L;
}
