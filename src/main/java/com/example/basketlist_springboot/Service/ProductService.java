package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public List<Product> getRandomThree();
    public Page<Product> getProductPageByCategory(String category,int page,int size); //카테고리별 목록 페이지화
    public List<Product> getProductListByUserNickname(String userNickname); //판매자가 상품판매목록 조회
    public Product getProductByProductName(String productName); //상품 번호로 상품 조회
    public Page<Product> searchProductsByKeyWord(String keyword,int page, int size);
    public void addProduct(Product product, Integer userId);
    public void deleteProduct(Integer productNo,Integer userId);
    public void updateProduct(Product product, Integer userId);
}
