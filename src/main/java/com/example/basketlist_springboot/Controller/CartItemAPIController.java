package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Dto.CartItemList;
import com.example.basketlist_springboot.Service.CartItemListService;
import com.example.basketlist_springboot.Service.UsersService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
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

    @GetMapping("/")
    ResponseEntity<?> getCartItemList(@RequestBody CartItemList cartItemList) {
        return null;
    }

}
