package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.UserDetails;

public interface UserDetailService {
    public void updateUserDetails(UserDetails userDetails,Integer userId);
}
