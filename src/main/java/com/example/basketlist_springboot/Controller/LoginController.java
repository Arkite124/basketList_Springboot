package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class LoginController {
    private final UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto dto, HttpServletRequest request) {
        UserDto userDto=usersService.LoginUsers(dto.getUserName(), dto.getPassword());
        if(userDto!=null) {
            HttpSession session=request.getSession();
            session.setAttribute("loginUser", userDto);
            return ResponseEntity.ok().body(userDto);
        }return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디나 비밀번호가 틀렸습니다!");
    }
}
