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
    @GetMapping("/userList")
    ResponseEntity<?> getUserList(@RequestParam String userNickname) {
        Users user = usersService.InfoSelectedUser(userNickname);
        if(user==null){
            return ResponseEntity.badRequest().body("존재하지 않는 유저입니다.");
        }
        List<CartItemList> ItemList=cartItemListService.getCartItemList(user.getUserId());
        return ResponseEntity.ok().body(ItemList);
    }


}
