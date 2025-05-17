package com.example.basketlist_springboot.Dao;

import com.example.basketlist_springboot.Dto.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductDao {
    int deleteById(BigDecimal productId); //기본적 상품 삭제
    int insert(Product record); //기본적 상품 등록
    int insertSelective(Product record); //선택적 상품 등록
    Product selectByPrimaryKey(BigDecimal productId); //상품 선택
    int updateByPrimaryKeySelective(Product record); //부분적 상품정보 업데이트
    int updateByPrimaryKey(Product record); //상품 정보 업데이트
}