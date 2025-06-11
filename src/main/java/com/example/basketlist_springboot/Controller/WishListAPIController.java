package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.WishList;
import com.example.basketlist_springboot.Service.WishListService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishList")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class WishListAPIController {
    private final WishListService wishListService;

    //위시리스트 보기
    @GetMapping("/wish")
    ResponseEntity<?> getWishList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원정보를 불러올 수 없습니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        List<WishList> wishLists=wishListService.getWishListByWishUserNo(user.getUserId());
        return ResponseEntity.ok(wishLists);
    }

    //위시리스트 담기
    @PostMapping("/wish")
    ResponseEntity<?> addWishList(@RequestBody WishList wishList, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원정보를 불러올 수 없습니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        wishList.setWishUserNo(user.getUserId());
        wishList.setWishProductNo(wishList.getWishProductNo());
        wishList.setAddedAt(wishList.getAddedAt());
        wishListService.addWishList(wishList);
        return ResponseEntity.ok().body(wishList);
    }

//    위시리스트 삭제
    @DeleteMapping("/wish")
    ResponseEntity<?> deleteWishList(@RequestBody WishList wishList, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원정보를 불러올 수 없습니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        wishListService.deleteWishList(user.getUserId(), wishList.getWishProductNo());
        return ResponseEntity.ok().body("삭제가 완료되었습니다.");
    }

}
