package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.Users;

public interface UserService {
    Users registerUsers(); //회원가입
    Users InfoUsers(); //사용자조회
}
