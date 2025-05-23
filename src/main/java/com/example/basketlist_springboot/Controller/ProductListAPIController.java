package com.example.basketlist_springboot.Controller;

import com.example.basketlist_springboot.Dto.Product;
import com.example.basketlist_springboot.Dto.UserDto;
import com.example.basketlist_springboot.Service.ProductService;
import com.example.basketlist_springboot.Service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ProductListAPIController {
    private final UsersService usersService;
    private final ProductService productService;

    @GetMapping("/list")
    public Page<Product> getProductPages(@RequestParam int page, @RequestParam int size) {
        return productService.getProductPage(page, size);
    }
    //모든 상품 조회

    @GetMapping("/list/{category}")
    public Page<Product> getProductPagesByCategory(@PathVariable String category, @RequestParam int page, @RequestParam int size) {
        return productService.getProductPageByCategory(category, page, size);
    }
    //선택한 카테고리별 상품 조회

    @GetMapping("/list/result/{keyword}")
    public Page<Product> searchProduct(@PathVariable String keyword, @RequestParam int page, @RequestParam int size) {
        return productService.searchProductsByKeyWord(keyword, page, size);
    }
    //상품 검색 결과 조회

    @PostMapping("/list")
    public ResponseEntity<?> addProduct(@RequestBody Product product, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        Product newProduct=new Product();
        newProduct.setProductQuantity(product.getProductQuantity());
        newProduct.setProductName(product.getProductName());
        newProduct.setProductCategory(product.getProductCategory());
        newProduct.setProductPrice(product.getProductPrice());
        newProduct.setProductDescription(product.getProductDescription());
        newProduct.setProductImgUrl(product.getProductImgUrl());
        newProduct.setProductAddedAt(Timestamp.valueOf(LocalDateTime.now()));
        productService.addProduct(newProduct,user.getUserId());
        return ResponseEntity.ok().body(newProduct);
    }
    //상품 등록

    @PutMapping("/list")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        Product updateProduct=productService.getProductByProductName(product.getProductName());
        updateProduct.setProductQuantity(product.getProductQuantity());
        updateProduct.setProductName(product.getProductName());
        updateProduct.setProductCategory(product.getProductCategory());
        updateProduct.setProductPrice(product.getProductPrice());
        updateProduct.setProductDescription(product.getProductDescription());
        updateProduct.setProductImgUrl(product.getProductImgUrl());
        updateProduct.setProductAddedAt(Timestamp.valueOf(LocalDateTime.now()));
        productService.updateProduct(updateProduct,user.getUserId());
        return ResponseEntity.ok().body(updateProduct);
    }
    // 상품 수정
    @DeleteMapping("/list")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto user = (UserDto) session.getAttribute("loginUser");
        if(product==null){
            return ResponseEntity.status(404).body("이미 삭제했거나 존재하지 않는 상품입니다.");
        }
        productService.deleteProduct(product.getProductId(),user.getUserId());
        return ResponseEntity.ok().body("삭제가 완료되었습니다");
    }
    //상품 삭제


}
