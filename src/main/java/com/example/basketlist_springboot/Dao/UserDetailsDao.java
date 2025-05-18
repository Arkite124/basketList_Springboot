package com.example.basketlist_springboot.Dao;

import com.example.basketlist_springboot.Dto.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDao {
    int insert(UserDetails record); //회원가입 2차절차 Not Null이 대부분이라 이걸 쓸듯
    int insertSelective(UserDetails record); //이걸 쓸 일이 있을까...?
}