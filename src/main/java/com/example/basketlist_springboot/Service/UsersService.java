package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserAndProductDto;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;

import java.util.List;

public interface UsersService {
    UserDto registerUsers(UserDto userDto); //회원가입
    UserDto InfoUsers(Integer userId); //사용자조회
    UserDto LoginUsers(String username, String password);
    void UpdateUsers(Users users, Integer userId);
    void deleteUser(Integer userId);
    Users getUserByUserNickname(String nickname);
    List<UserAndProductDto> getUserProducts(Integer userId);
}
