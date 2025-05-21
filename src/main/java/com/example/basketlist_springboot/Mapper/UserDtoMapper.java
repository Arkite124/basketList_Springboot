package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.UserDetails;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserDtoMapper  {
    UserDto getUserDtoByUserId(int userId);
    UserDto getUserDtoByUserNameAndPassword(Map<String,String> map);
    UserDto getUserDtoByUserName(String userName);
}
