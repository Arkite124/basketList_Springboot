package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Dto.CartItemList;
import com.example.basketlist_springboot.Dto.CartItemListDto;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Service.CartItemListService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/cartItemList")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CartItemAPIController {
    private final CartItemListService cartItemListService;

    //List 가져오기
    @GetMapping("/myList")
    ResponseEntity<?> getCartItemList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        List<CartItemList> ItemList=cartItemListService.getCartItemListDetail(user.getUserId());
        return ResponseEntity.ok().body(ItemList);
    }

    // totalPrice 가져오기
    @GetMapping("/myList/totalPrice")
    ResponseEntity<?> getCartItemListTotalPrice(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        Integer totalPrice=cartItemListService.totalCartPrice(user.getUserId());
        return ResponseEntity.ok().body(totalPrice);
    }

//    장바구니에 등록하기
    @PostMapping("/myList")
    ResponseEntity<?> addCartItem(@RequestBody CartItemListDto cartItemListDto, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원정보를 불러올 수 없습니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        Integer checkDuplicate=cartItemListService.checkCartItemDuplicate(cartItemListDto.getProductNo(),user.getUserId());
        if(checkDuplicate>=1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 장바구니에 담긴 상품입니다.");
        }
        cartItemListService.createCartItemList(user.getUserId(),cartItemListDto.getProductNo()
                ,cartItemListDto.getQuantity());
        return ResponseEntity.ok().body("장바구니에 추가되었습니다.");
    }

//    장바구니에서 삭제하기
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

    //수정할것은 수량 뿐이므로, 수량만 업데이트
    @PutMapping("/myList")
    ResponseEntity<?> updateCartItem(@RequestBody CartItemList cartItemList, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원정보를 불러올 수 없습니다.");
        }
        cartItemListService.updateCartItemQuantity(cartItemList.getCartItemId(),cartItemList.getQuantity());
        return ResponseEntity.ok().body("수량이 수정되었습니다.");
    }

    //전체삭제
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
