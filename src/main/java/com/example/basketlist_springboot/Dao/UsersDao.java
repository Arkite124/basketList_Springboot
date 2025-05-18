package com.example.basketlist_springboot.Dao;

import com.example.basketlist_springboot.Dto.Users;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UsersDao {
    int deleteByUserId(BigDecimal userId); //회원 탈퇴
    int insert(Users record); //회원가입 1차
    int insertSelective(Users record); //이건 안쓸듯
    Users selectByUserId(BigDecimal userId); //특정 유저 조회
    int updateByPrimaryKeySelective(Users record); //유저정보 업데이트(선택적이니 이게 더 적절할듯)
    int updateByPrimaryKey(Users record);//전체정보 수정(이건 많이 안쓸듯)
}