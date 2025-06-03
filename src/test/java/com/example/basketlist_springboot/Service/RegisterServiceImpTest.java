package com.example.basketlist_springboot.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegisterServiceImpTest {
    @Autowired
    RegisterService registerService;

    @Test
    void checkDuplicateUsername() {
        System.out.println(registerService.checkDuplicateUsername("admin1"));
    }

    @Test
    void checkDuplicateUserNickname() {
        System.out.println(registerService.checkDuplicateUserNickname("굿셀러"));
    }

    @Test
    void checkDuplicateEmail() {
    }

    @Test
    void checkDuplicatePhoneNumber() {
    }

    @Test
    void checkPrivacyAgreement() {
    }

    @Test
    void checkConfirmPassword() {
    }
}