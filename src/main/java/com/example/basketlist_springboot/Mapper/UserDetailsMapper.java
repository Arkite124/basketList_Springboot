package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.UserDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailsMapper {
    int insert(UserDetails record); //회원가입 2차절차 Not Null이 대부분이라 이걸 쓸듯
    UserDetails selectUserDetailsByDetailUserId(Integer detailUserId);
}