package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Mapper.UserDetailsMapper;
import com.example.basketlist_springboot.Mapper.UsersMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterServiceImp implements RegisterService {
    private final UsersMapper usersMapper;
    private final UserDetailsMapper userDetailsMapper;

    @Override
    public Boolean checkDuplicateUsername(String username) {
        String checkUserName=usersMapper.checkUserName(username);
        if(checkUserName!=null){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkDuplicateUserNickname(String nickname) {
        String checkUserNickname=usersMapper.checkUserNickName(nickname);
        if(checkUserNickname!=null){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkDuplicateEmail(String email) {
        String checkEmail= userDetailsMapper.checkUserEmail(email);
        if(checkEmail!=null){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkDuplicatePhoneNumber(String phoneNumber) {
        String checkPhone= userDetailsMapper.checkUserPhone(phoneNumber);
        if(checkPhone!=null){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkPrivacyAgreement(Integer privacyAgreement) {
        Integer checkPrivacyAgreement= userDetailsMapper.checkPrivacyAgreement(privacyAgreement);
        if(checkPrivacyAgreement==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkConfirmPassword(String password, String confirmPassword) {
        if(password.equals(confirmPassword)){
            return true;
        }
        return false;
    }
}
