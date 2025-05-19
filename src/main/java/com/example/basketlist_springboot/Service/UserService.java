package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Users registerUsers(); //회원가입
    Users InfoUsers(); //사용자조회
}
