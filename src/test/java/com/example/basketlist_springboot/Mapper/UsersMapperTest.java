package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.Users;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersMapperTest {
    @Autowired
    private UsersMapper usersMapper;

    @Test
    void selectUserAndUserDetailByUserId() {
        Integer userId=1;
        Users userInfo = usersMapper.selectUserAndUserDetailByUserId(userId);
        System.out.println(userInfo);
    }
}