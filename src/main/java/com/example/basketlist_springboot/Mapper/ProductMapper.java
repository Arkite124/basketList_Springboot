package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    int deleteById(Integer productId); //기본적 상품 삭제
    int insert(Product record); //기본적 상품 등록 사진 없어도 걍 null로 등록되게
    Product selectByProductId(Integer productId); //상품 선택
    List<Product> selectAll(); //전체 상품 조회
    int updateByPrimaryKeySelective(Product record); //부분적 상품정보 업데이트
    int updateByPrimaryKey(Product record);//상품 정보 업데이트
    List<Product> selectByProductCategory(String productCategory); //카테고리별 상품 조회
    Product selectByProductIdAndProductCategory(Map<String, Object> map); //카테고리 안에서 상품 선택
}