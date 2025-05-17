package com.example.basketlist_springboot.Dao;

import com.example.basketlist_springboot.Dto.Userdetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserdetailsDao {
    int insert(Userdetails record);

    int insertSelective(Userdetails record);
}