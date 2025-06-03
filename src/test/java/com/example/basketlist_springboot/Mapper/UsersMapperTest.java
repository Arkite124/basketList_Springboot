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
        String nickName="굿셀러";
        Users users=usersMapper.selectUserByUserNickName(nickName);
        Integer userId=users.getUserId();
        Users userInfo = usersMapper.selectUserAndUserDetailByUserId(userId);
        System.out.println(userInfo);
    }

    @Test
    void deleteByUserId() {
    }

    @Test
    void insert() {
    }

    @Test
    void selectByUserId() {
    }

    @Test
    void updateByIdSelective() {
    }

    @Test
    void selectUserByUserNickName() {
        String nickName="굿셀러";
        System.out.println(usersMapper.selectUserByUserNickName(nickName));
    }

    @Test
    void checkUserName() {
        String userName="admin1";
        System.out.println(usersMapper.checkUserName(userName));
    }

    @Test
    void checkUserNickName() {
        String nickName="굿셀러1";
        System.out.println(usersMapper.checkUserNickName(nickName));
    }
}