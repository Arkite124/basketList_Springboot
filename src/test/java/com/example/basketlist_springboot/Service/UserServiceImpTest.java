package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Mapper.UserDetailsMapper;
import com.example.basketlist_springboot.Mapper.UsersMapper;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImpTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserDetailsMapper userDetailsMapper;
    @Test
    @Transactional
    void registerUsers() {
        UserDto userDto = new UserDto();
        userDto.setUserName("goododo");
        userDto.setPassword("pass1234");
        userDto.setProfileImgUrl(null);
        userDto.setUserNickname("좋아요");
        userDto.setRole("BOTH");//user
        userDto.setEmail("good@example.com");
        userDto.setPhone("01012345678");
        userDto.setPrivacyAgreements((short) 1);
        userDto.setMarketingAgreements((short) 1);
        userDto.setName("더조아");
        userDto.setBirthDate(Timestamp.valueOf("1996-01-03 03:00:00"));//userDetails
        UserDto newUserDto=userService.registerUsers(userDto);
        System.out.println(newUserDto);
    }

    @Test
    void infoUsers() {
        Users selectedUser=userService.InfoUsers(4);
        System.out.println(selectedUser);
    }
}