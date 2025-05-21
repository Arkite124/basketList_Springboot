package com.example.basketlist_springboot.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PasswordConfigTest {
    @Autowired
    private PasswordConfig passwordConfig;

    @Test
    void getPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("pass1234");
        System.out.println(encodedPassword);
//        $2a$10$RAlUFBIy2g.eTHPdzVUQGesNe9Cij5rGDL4B08sehf7fkBcKQorwq = pass1234
    }

}