package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.UserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDetailsMapperTest {
    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Test
    void updateUserDetailsSelective() {
        UserDetails userDetails = userDetailsMapper.selectUserDetailsByDetailUserId(9);
        System.out.println(userDetails);
        UserDetails userDetails2 = new UserDetails();
        userDetails2.setEmail("example1111@example.com");
        userDetails.setEmail(userDetails2.getEmail());
        userDetailsMapper.updateUserDetailsSelective(userDetails);
        userDetailsMapper.selectUserDetailsByDetailUserId(9);
        System.out.println(userDetails);
    }
}