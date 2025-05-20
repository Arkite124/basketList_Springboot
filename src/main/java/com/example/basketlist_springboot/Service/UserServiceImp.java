package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserDetails;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Mapper.UserDetailsMapper;
import com.example.basketlist_springboot.Mapper.UserDtoMapper;
import com.example.basketlist_springboot.Mapper.UsersMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final UsersMapper usersMapper;
    private final UserDetailsMapper userDetailsMapper;
    private final UserDtoMapper userDtoMapper;

    @Override
    @Transactional
    public UserDto registerUsers(UserDto userDto) {
        Users users = new Users();
        users.setUserName(userDto.getUserName());
        users.setPassword(userDto.getPassword());
        users.setUserNickname(userDto.getUserNickname());
        users.setProfileImgUrl(userDto.getProfileImgUrl());
        users.setRole(userDto.getRole());
        usersMapper.insert(users);
        UserDetails userDetails = new UserDetails();
        userDetails.setDetailUserNo(users.getUserId());
        userDetails.setName(userDto.getName());
        userDetails.setEmail(userDto.getEmail());
        userDetails.setPhone(userDto.getPhone());
        userDetails.setBirthDate(userDto.getBirthDate());
        userDetails.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userDetails.setMarketingAgreements(userDto.getMarketingAgreements());
        userDetails.setPrivacyAgreements(userDto.getPrivacyAgreements());
        userDto.setUserId(users.getUserId());
        userDetailsMapper.insert(userDetails);
        users.setUserDetails(userDetails);
        if(userDetails!=null && userDetails.getPrivacyAgreements()==1){
            return userDto;
        }
        if(userDetails==null){
            usersMapper.deleteByUserId(users.getUserId());
        }
        return null;
    }

    @Override
    @Transactional
    public Users InfoUsers(Integer userId) {
        Users selectedUserDetail=usersMapper.selectUserAndUserDetailByUserId(userId);
        return selectedUserDetail;
    }
}
