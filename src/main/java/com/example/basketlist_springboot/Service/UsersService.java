package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;

public interface UsersService {
    UserDto registerUsers(UserDto userDto); //회원가입
    Users InfoUsers(Integer userId); //사용자조회
    UserDto LoginUsers(String userName, String password);
    Integer UpdateUsers(Users users, Integer userId);
    Users InfoSelectedUser(String userNickname);
    void deleteUser(Integer userId);

}
