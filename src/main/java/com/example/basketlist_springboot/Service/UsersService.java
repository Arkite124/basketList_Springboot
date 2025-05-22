package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;

import java.util.Map;

public interface UsersService {
    UserDto registerUsers(UserDto userDto); //회원가입
    Users InfoUsers(Integer userId); //사용자조회
    UserDto LoginUsers(String userName, String password);
    void deleteUser(Integer userId);

}
