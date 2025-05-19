package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDtoMapper {
    UserDto getUserDtoByUserId(int userId);
}
