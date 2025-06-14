package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Mapper.UserDetailsMapper;
import com.example.basketlist_springboot.Mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class UsersServiceImpTest {
    @Autowired
    private UsersService usersService;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserDetailsMapper userDetailsMapper;
    @Test
    @Transactional
    void registerUsers() {
        UserDto userDto = new UserDto();
        userDto.setUserName("goododo");
        String password = "pass1234";
        String BcryptPw= BCrypt.hashpw(password, BCrypt.gensalt());
        userDto.setPassword(BcryptPw);
        userDto.setProfileImgUrl(null);
        userDto.setUserNickname("좋아요");
        userDto.setRole("BOTH");//user
        userDto.setEmail("good@example.com");
        userDto.setPhone("01012345678");
        userDto.setPrivacyAgreements(true);
        userDto.setMarketingAgreements(false);
        userDto.setName("더조아");
        userDto.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userDto.setBirthDate(LocalDate.parse("1996-01-03 03:00:00"));//userDetails
        UserDto newUserDto= usersService.registerUsers(userDto);
        System.out.println(newUserDto);
    }

    @Test
    void infoUsers() {
        UserDto selectedUser= usersService.InfoUsers(4);
        System.out.println(selectedUser);
    }

    @Test
    void loginUsers() {
        UserDto loginUser=usersService.LoginUsers("goodseller1","pass1234");
        System.out.println(loginUser);
    }

    @Test
    void getUserProducts() {
        System.out.println(usersService.getUserProducts(3));
    }
}