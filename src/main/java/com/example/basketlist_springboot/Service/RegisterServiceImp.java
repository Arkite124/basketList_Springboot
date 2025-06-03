package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Mapper.UserDetailsMapper;
import com.example.basketlist_springboot.Mapper.UsersMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegisterServiceImp implements RegisterService {
    private final UsersMapper usersMapper;
    private final UserDetailsMapper userDetailsMapper;

    @Override
    @Transactional
    public Boolean checkDuplicateUsername(String userName) {
        Integer checkUserName=usersMapper.checkUserName(userName);
        if(checkUserName==0){
            return true;
        }
        if(userName.length()<6) return false;
        if(checkUserName==1) return false;
        return false;
    }

    @Override
    @Transactional
    public Boolean checkDuplicateUserNickname(String nickname) {
        Integer checkUserNickname=usersMapper.checkUserNickName(nickname);
        if(checkUserNickname==0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean checkDuplicateEmail(String email) {
        Integer checkEmail= userDetailsMapper.checkUserEmail(email);
        if(checkEmail==0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean checkDuplicatePhoneNumber(String phoneNumber) {
        Integer checkPhone= userDetailsMapper.checkUserPhone(phoneNumber);
        if(checkPhone==1){
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean checkPrivacyAgreement(Integer privacyAgreement) {
        Integer checkPrivacyAgreement= userDetailsMapper.checkPrivacyAgreement(privacyAgreement);
        if(checkPrivacyAgreement==1){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean checkConfirmPassword(String password, String confirmPassword) {
        if(password.equals(confirmPassword)){
            return true;
        }
        return false;
    }
}
