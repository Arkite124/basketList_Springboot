package com.example.basketlist_springboot.Mapper;

import com.example.basketlist_springboot.Dto.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    int deleteByProductIdAndProductUserNo(Map<String,Integer> map); //기본적 상품 삭제
    int insertProduct(Product product); //기본적 상품 등록 사진 없어도 걍 null로 등록되게
    Product selectByProductId(Integer productId); //상품 선택
    List<Product> selectAll();//전체 상품 조회
    List<Product> selectByCategory(String category); //카테고리별 상품 리스트 조회
    int updateByPrimaryKeySelective(Product record); //부분적 상품정보 업데이트
    int updateByPrimaryKey(Product record);//상품 정보 업데이트
    List<Product> selectProductListByProductUserNo(Integer productUserNo); //판매자가 자기 판매리스트 상품 조회
    List<Product> selectByProductCategory(String productCategory); //카테고리별 상품 조회
    Product selectByProductIdAndProductCategory(Map<String, Object> map); //카테고리 안에서 상품 선택
    List<Product> selectProductListLikeProductName(String keyWord); //키워드로 상품 목록 검색하는 기능
}