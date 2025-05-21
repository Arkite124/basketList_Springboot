package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserAPIController {
    private final UsersService usersService;
}
