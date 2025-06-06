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
        Users users = new Users();
        Integer checkUserName=usersMapper.checkUserName(userDto.getUserName());
        if(checkUserName==1 || userDto.getUserName()==null){
            return null;
        }
        users.setUserName(userDto.getUserName());
        String BcryptPw= BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        users.setPassword(BcryptPw);
        Integer checkUserNickname=usersMapper.checkUserNickName(userDto.getUserName());
        if(checkUserNickname==1 || userDto.getUserNickname()==null){
            return null;
        }
        users.setUserNickname(userDto.getUserNickname());
        users.setProfileImgUrl(userDto.getProfileImgUrl());
        users.setRole(userDto.getRole());
        users.setSelfIntroduction(userDto.getSelfIntroduction());
        usersMapper.insert(users);
        UserDetails userDetails = new UserDetails();
        userDetails.setDetailUserNo(users.getUserId());
        userDetails.setName(userDto.getName());
        Integer checkEmail= userDetailsMapper.checkUserEmail(userDto.getEmail());
        if(checkEmail==1 || userDto.getEmail()==null){
            return null;
        }
        userDetails.setEmail(userDto.getEmail());
        Integer checkPhone= userDetailsMapper.checkUserPhone(userDto.getPhone());
        if(checkPhone==1 || userDto.getPhone()==null){
            return null;
        }
        userDetails.setPhone(userDto.getPhone());
        userDetails.setBirthDate(userDto.getBirthDate());
        userDetails.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userDetails.setMarketingAgreements(userDto.getMarketingAgreements());
        Boolean privacyAgreement= userDto.getPrivacyAgreements();
        if(privacyAgreement!=true){
            return null;
        }
        userDetails.setPrivacyAgreements(true);
        userDetails.setMarketingAgreements(userDto.getMarketingAgreements());
        userDto.setUserId(users.getUserId());
        userDetailsMapper.insert(userDetails);
        users.setUserDetails(userDetails);
        if(userDetails!=null && userDetails.getPrivacyAgreements()==true){
            return userDto;
        }
        if(userDetails==null){
            usersMapper.deleteByUserId(users.getUserId());
        }
        return null;
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
