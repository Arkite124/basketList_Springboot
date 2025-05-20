package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserDetails;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;

public interface UserService {
    public UserDto registerUsers(UserDto userDto); //회원가입
    Users InfoUsers(Integer userId); //사용자조회
}
