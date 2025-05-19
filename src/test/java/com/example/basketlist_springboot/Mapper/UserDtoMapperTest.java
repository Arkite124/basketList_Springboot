package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDtoMapperTest {
    @Autowired
    UserDtoMapper userDtoMapper;

    @Test
    @Transactional
    void getUserDtoByUserId() {
        UserDto userDto = userDtoMapper.getUserDtoByUserId(1);
        System.out.println(userDto);
    }
}