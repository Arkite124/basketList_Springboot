package com.example.basketlist_springboot.Dao;

import com.example.basketlist_springboot.Dto.Users;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UsersDao {
    int deleteByPrimaryKey(BigDecimal userId);
    int insert(Users record);
    int insertSelective(Users record);
    Users selectByPrimaryKey(BigDecimal userId);
    int updateByPrimaryKeySelective(Users record); //
    int updateByPrimaryKey(Users record);
}