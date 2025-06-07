package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserDetails;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Mapper.UserDetailsMapper;
import com.example.basketlist_springboot.Mapper.UserDtoMapper;
import com.example.basketlist_springboot.Mapper.UsersMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UsersServiceImp implements UsersService {
    private final UsersMapper usersMapper;
    private final UserDetailsMapper userDetailsMapper;
    private final UserDtoMapper userDtoMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public UserDto registerUsers(UserDto userDto) {
        if (Boolean.FALSE.equals(userDto.getPrivacyAgreements())) {
            // 개인정보 제공 동의가 필수
            return null;
        }
        // 사용자 정보 세팅
        Users users = new Users();
        users.setUserName(userDto.getUserName());
        users.setPassword(BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt()));
        users.setUserNickname(userDto.getUserNickname());
        users.setProfileImgUrl(userDto.getProfileImgUrl());
        users.setRole(userDto.getRole());
        users.setSelfIntroduction(userDto.getSelfIntroduction());
        usersMapper.insert(users); // 먼저 Users 저장 (userId 생성됨)
        // 상세 정보 세팅
        UserDetails userDetails = new UserDetails();
        userDetails.setDetailUserNo(users.getUserId());
        userDetails.setName(userDto.getName());
        userDetails.setEmail(userDto.getEmail());
        userDetails.setPhone(userDto.getPhone());
        // LocalDate → Timestamp 변환
        if (userDto.getBirthDate() != null) {
            userDetails.setBirthDate(Timestamp.valueOf(userDto.getBirthDate().atStartOfDay()));
        }
        userDetails.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userDetails.setPrivacyAgreements(true);
        userDetails.setMarketingAgreements(userDto.getMarketingAgreements());
        userDetailsMapper.insert(userDetails);
        // insert 후 DTO에 ID 세팅
        userDto.setUserId(users.getUserId());
        // 사용자 객체와 상세 정보 연결
        users.setUserDetails(userDetails);
        return userDto;
    }

    @Override
    @Transactional
    public UserDto InfoUsers(Integer userId) {
        UserDto selectedUserDto=userDtoMapper.getUserDtoByUserId(userId);
        return selectedUserDto;
    }

    @Override
    public UserDto LoginUsers(String username, String password) {
        UserDto user=userDtoMapper.getUserDtoByUserName(username);
        if(user!=null && passwordEncoder.matches(password,user.getPassword())){
            return userDtoMapper.getUserDtoByUserId(user.getUserId());
        }
        else return null;
    }

    @Override
    public void UpdateUsers(Users users, Integer userId) {
        Users selectedUser=usersMapper.selectByUserId(userId);
        selectedUser.setUserName(users.getUserName());
        selectedUser.setPassword(users.getPassword());
        selectedUser.setProfileImgUrl(users.getProfileImgUrl());
        selectedUser.setRole(users.getRole());
        selectedUser.setUserNickname(users.getUserNickname());
        usersMapper.updateByIdSelective(selectedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        usersMapper.deleteByUserId(userId);
    }

    @Override
    public Users getUserByUserNickname(String nickname) {
        Users users=usersMapper.selectUserByUserNickName(nickname);
        return users;
    }
}
