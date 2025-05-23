package com.example.basketlist_springboot.Service;

public interface RegisterService {
    public Boolean checkDuplicateUsername(String username);
    public Boolean checkDuplicateUserNickname(String nickname);
    public Boolean checkDuplicateEmail(String email);
    public Boolean checkDuplicatePhoneNumber(String phoneNumber);
    public Boolean checkPrivacyAgreement(Integer privacyAgreement);
    public Boolean checkConfirmPassword(String password, String confirmPassword);
}
