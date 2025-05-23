package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserDetails;
import com.example.basketlist_springboot.Mapper.UserDetailsMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImp implements UserDetailService {
    private final UserDetailsMapper userDetailsMapper;

    @Override
    public void updateUserDetails(UserDetails userDetails,Integer userId) {
        UserDetails selectedUserDetails=userDetailsMapper.selectUserDetailsByDetailUserId(userId);
        selectedUserDetails.setName(userDetails.getName());
        selectedUserDetails.setEmail(userDetails.getEmail());
        selectedUserDetails.setPhone(userDetails.getPhone());
        selectedUserDetails.setCreatedAt(selectedUserDetails.getCreatedAt());
        selectedUserDetails.setBirthDate(userDetails.getBirthDate());
        selectedUserDetails.setPrivacyAgreements(userDetails.getPrivacyAgreements());
        selectedUserDetails.setMarketingAgreements(userDetails.getMarketingAgreements());
        userDetailsMapper.updateUserDetailsSelective(selectedUserDetails);
    }
}
