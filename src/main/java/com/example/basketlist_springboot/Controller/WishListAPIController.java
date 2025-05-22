package com.example.basketlist_springboot.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wishList")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class WishListAPIController {
}
