package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Dto.UserAndProductDto;
import com.example.basketlist_springboot.Dto.UserDetails;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Service.UserDetailService;
import com.example.basketlist_springboot.Service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserAPIController {
    private final UsersService usersService;
    private final UserDetailService userDetailService;

//    단순 유저정보
    @GetMapping("/userInfo")
    public ResponseEntity<?> getUserInfo(@RequestParam String userNickname) {
        Users userInfo=usersService.getUserByUserNickname(userNickname);
        System.out.println("유저 정보 :"+userInfo);
        return ResponseEntity.ok().body(userInfo);
    }

    //판매자 판매 상품 정보 -> 상품에 넣을지 사용자에 넣을지 애매해서 사용자에 넣었습니다.
    @GetMapping("/sellerInfo")
    public ResponseEntity<?> getSellerInfo(@RequestParam String userNickname) {
        Users user=usersService.getUserByUserNickname(userNickname);
        Integer userId= user.getUserId();
        if(!Objects.equals(user.getRole(), "BUYER")){
            List<UserAndProductDto> userAndProductDtoList=usersService.getUserProducts(userId);
            return ResponseEntity.ok().body(userAndProductDtoList);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("사용자 역할이 구매자인 분은 접근불가입니다.");
    }

//    내 정보
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
        UserDto userInfo=usersService.InfoUsers(user.getUserId());
        System.out.println("유저 정보 :"+user);
        return ResponseEntity.ok().body(userInfo);
    }

//    내 정보 수정
    @PutMapping("/myInfo")
    public ResponseEntity<?> updateMyInfo(HttpServletRequest request, @RequestBody Users users) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto userDto = (UserDto) session.getAttribute("loginUser");
        if(users==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 했나 확인해보세요.");
        }
        userDto.setUserName(users.getUserName());
        userDto.setPassword(users.getPassword());
        userDto.setProfileImgUrl(users.getProfileImgUrl());
        userDto.setRole(users.getRole());
        userDto.setUserNickname(users.getUserNickname());
        usersService.UpdateUsers(users, userDto.getUserId());
        return ResponseEntity.ok().body("회원기본정보 수정 완료");
    }

//    내 상세정보 수정
    @PutMapping("/myInfo/details")
    public ResponseEntity<?> updateMyInfoDetails(HttpServletRequest request, @RequestBody UserDetails userDetails) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto userDto = (UserDto) session.getAttribute("loginUser");
        if(userDto==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 했나 확인해보세요.");
        }
        userDetails.setMarketingAgreements(userDto.getMarketingAgreements());
        userDetails.setEmail(userDto.getEmail());
        userDetails.setBirthDate(Timestamp.valueOf(userDto.getBirthDate().atStartOfDay()));
        userDetails.setPhone(userDto.getPhone());
        userDetails.setPrivacyAgreements(userDto.getPrivacyAgreements());
        userDetails.setDetailUserNo(userDto.getUserId());
        userDetails.setName(userDto.getUserName());
        userDetails.setCreatedAt(userDto.getCreatedAt());
        userDetailService.updateUserDetails(userDetails, userDto.getUserId());
        return ResponseEntity.ok().body("회원 세부정보 수정 완료");
    }

//    회원 탈퇴
    @DeleteMapping("/myInfo")
    public ResponseEntity<?> deleteMyInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto userDto = (UserDto) session.getAttribute("loginUser");
        Integer userId = userDto.getUserId();
        usersService.deleteUser(userId);
        return ResponseEntity.ok().body("탈퇴가 완료되었습니다.");
    }
}
