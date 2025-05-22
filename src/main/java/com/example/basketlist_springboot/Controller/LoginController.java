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
@RequestMapping("/api/userStatus")
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

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
       session.invalidate();
       return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto dto) {
        UserDto newUserDto=usersService.registerUsers(dto);
        if(newUserDto==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원가입에 실패했습니다.");
        }
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
