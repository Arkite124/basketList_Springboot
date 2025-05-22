package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserAPIController {
    private final UsersService usersService;

    @GetMapping("/info")
    public ResponseEntity<?> getUserInfo(@RequestParam String userNickname) {
        Users userInfo=usersService.InfoSelectedUser(userNickname);
        System.out.println("유저 정보 :"+userInfo);
        return ResponseEntity.ok().body(userInfo);
    }

    @GetMapping("/myInfo")
    public ResponseEntity<?> getMyInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        if(user==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 했나 확인해보세요.");
        }
        Users userInfo=usersService.InfoUsers(user.getUserId());
        System.out.println("유저 정보 :"+user);
        return ResponseEntity.ok().body(userInfo);
    }

    @PutMapping("/myInfo")
    public ResponseEntity<?> updateMyInfo(HttpServletRequest request, @RequestBody UserDto users) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto userDto = (UserDto) session.getAttribute("loginUser");
        if(users==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 했나 확인해보세요.");
        }

        return ResponseEntity.ok().body("userId");
    }
}
