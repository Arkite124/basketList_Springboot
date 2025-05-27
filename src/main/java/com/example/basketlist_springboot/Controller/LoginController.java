package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Dto.LoginDto;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Mapper.UserDtoMapper;
import com.example.basketlist_springboot.Service.UsersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userStatus")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class LoginController {
    private final UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto, HttpServletRequest request) {
        UserDto user=usersService.LoginUsers(dto.getUserName(), dto.getPassword());
        if(user!=null) {
            HttpSession session=request.getSession();
            UserDto userDto=usersService.InfoUsers(user.getUserId());
            session.setAttribute("loginUser", userDto);
            return ResponseEntity.ok().body(userDto);
        }return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디나 비밀번호가 틀렸습니다!");
    }

    @GetMapping("/login/me")
    public ResponseEntity<?> me(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession(false);
        if(session!=null) {
            UserDto user=(UserDto)session.getAttribute("loginUser");
            return ResponseEntity.ok().body(user);
        }
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie.setPath("/"); // 애플리케이션 루트 경로 기준으로 설정
        response.addCookie(cookie);
        return ResponseEntity.ok().body("세션이 만료되어서 로그아웃 됩니다!");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session=request.getSession();
        if(session!=null) {
            session.invalidate();
        }
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie.setPath("/"); // 애플리케이션 루트 경로 기준으로 설정
        response.addCookie(cookie);
       return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    private ResponseEntity<?> delete(@RequestBody UserDto dto, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        if(user==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("세션이 만료되었거나 " +
                    "로그인이 필요합니다. 혹은 오류로 유저데이터가 없습니다.");
        }
        usersService.deleteUser(user.getUserId());
        return ResponseEntity.ok().build();
    }
}
