package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDtoMapperTest {
    @Autowired
    UserDtoMapper userDtoMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @Transactional
    void getUserDtoByUserId() {
        UserDto userDto = userDtoMapper.getUserDtoByUserId(1);
        System.out.println(userDto);
    }

    @Test
    void getUserDtoByUserNameAndPassword() {
        Map<String,String> map = new HashMap<>();
        map.put("userName","goodseller1");
        map.put("password","pass1234");
        UserDto userDto = userDtoMapper.getUserDtoByUserNameAndPassword(map);
        System.out.println(userDto);
    }
}