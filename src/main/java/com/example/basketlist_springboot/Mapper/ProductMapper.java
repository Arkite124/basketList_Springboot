package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int deleteById(Integer productId); //기본적 상품 삭제
    int insert(Product record); //기본적 상품 등록 사진 없어도 걍 null로 등록되게
    Product selectByPrimaryKey(Integer productId); //상품 선택
    int updateByPrimaryKeySelective(Product record); //부분적 상품정보 업데이트
    int updateByPrimaryKey(Product record); //상품 정보 업데이트
}