package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {
    int deleteByUserId(Integer userId); //회원 탈퇴
    int insert(Users record); //회원가입 1차
    int insertSelective(Users record); //이건 안쓸듯
    Users selectByUserId(Integer userId); //특정 유저 조회
    int updateByIdSelective(Users record); //유저정보 업데이트(선택적이니 이게 더 적절할듯)
    int updateById(Users record);//전체정보 수정(이건 많이 안쓸듯)
    Users selectUserAndUserDetailByUserId(Integer userId);
}