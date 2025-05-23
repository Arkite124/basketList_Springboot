package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;

public interface UsersService {
    UserDto registerUsers(UserDto userDto); //회원가입
    UserDto InfoUsers(Integer userId); //사용자조회
    UserDto LoginUsers(String userName, String password);
    void UpdateUsers(Users users, Integer userId);
    void deleteUser(Integer userId);
    Users getUserByUserNickname(String nickname);

}
