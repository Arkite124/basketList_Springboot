package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.UserDetails;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootTest
class UserDetailsDaoTest {
    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Test
    void selectUserDetailsByDetailUserNo() {
        UserDetails userDetails=userDetailsMapper.selectUserDetailsByDetailUserId(1);
        System.out.println(userDetails);
    }
}