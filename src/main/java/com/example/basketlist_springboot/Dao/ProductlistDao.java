package com.example.basketlist_springboot.Dao;

import com.example.basketlist_springboot.Dto.Productlist;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductlistDao {
    int deleteByPrimaryKey(BigDecimal cartItemId);

    int insert(Productlist record);

    int insertSelective(Productlist record);

    Productlist selectByPrimaryKey(BigDecimal cartItemId);

    int updateByPrimaryKeySelective(Productlist record);

    int updateByPrimaryKey(Productlist record);
}