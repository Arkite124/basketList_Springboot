package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Dto.CartItemList;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Service.CartItemListService;
import com.example.basketlist_springboot.Service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/cartItemList")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CartItemAPIController {
    private final CartItemListService cartItemListService;
    private final UsersService usersService;

    @GetMapping("/myList")
    ResponseEntity<?> getCartItemList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        List<CartItemList> ItemList=cartItemListService.getCartItemList(user.getUserId());
        return ResponseEntity.ok().body(ItemList);
    }

    @PostMapping("/myList")
    ResponseEntity<?> addCartItem(@RequestBody CartItemList cartItemList, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원정보를 불러올 수 없습니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        cartItemListService.createCartItemList(user.getUserId(),cartItemList.getProductNo()
                ,cartItemList.getQuantity(),Timestamp.valueOf(LocalDateTime.now()));
        return ResponseEntity.ok().body("장바구니에 추가되었습니다.");
    }

    @DeleteMapping("/myList")
    ResponseEntity<?> deleteCartItem(@RequestBody CartItemList cartItemList, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원정보를 불러올 수 없습니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        cartItemListService.deleteCartItem(cartItemList.getCartItemId());
        return ResponseEntity.ok().body("장바구니에서 삭제되었습니다.");
    }
    @DeleteMapping("/myList/All")
    ResponseEntity<?> deleteAllCartItems(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원정보를 불러올 수 없습니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        cartItemListService.deleteAllCartItems(user.getUserId());
        return ResponseEntity.ok().body("장바구니 초기화를 완료했습니다.");
    }

}
