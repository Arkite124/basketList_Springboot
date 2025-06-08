package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.Product;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Mapper.ProductMapper;
import com.example.basketlist_springboot.Mapper.UsersMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductMapper productMapper;
    private final UsersMapper usersMapper;

    @Override
    public List<Product> getRandomThree() {
        return productMapper.selectRandomThree();
    }

    @Override
    public Page<Product> getProductPageByCategory(String category, int page, int size) {
        Map<String,Object> map=new HashMap<>();
        Integer offset=page*size;
        if(category!=null){
        map.put("category",category);}
        map.put("offset",offset);
        map.put("size",size);
        List<Product> productList=productMapper.selectByCategory(map);
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage=new PageImpl<>(productList,pageable,productList.size());
        return productPage;
    }

    @Override
    public List<Product> getProductListByUserNickname(String userNickname) {
        Users user=usersMapper.selectUserByUserNickName(userNickname);
        if(user.getRole().equals("BUYER")){
            return null;
        }
        List<Product> productList=productMapper.selectProductListByProductUserNickname(userNickname);
        return productList;
    }

    @Override
    public Product getProductByProductName(String productName) {
        return productMapper.selectByProductName(productName);
    }

    @Override
    public Page<Product> searchProductsByKeyWord(String keyword, int page, int size) {
        Map<String,Object> map=new HashMap<>();
        Integer offset=page*size;
        map.put("keyword",keyword);
        map.put("offset",offset);
        map.put("size",size);
        List<Product> productList=productMapper.selectProductListLikeProductName(map);
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage=new PageImpl<>(productList,pageable,productList.size());
        return productPage;
    }

    @Override
    public void addProduct(Product product, Integer userId) {
        Product newProduct=new Product();
        newProduct.setProductCategory(product.getProductCategory());
        newProduct.setProductName(product.getProductName());
        newProduct.setProductPrice(product.getProductPrice());
        newProduct.setProductDescription(product.getProductDescription());
        newProduct.setProductUserNo(userId);
        newProduct.setProductQuantity(product.getProductQuantity());
        newProduct.setProductImgUrl(product.getProductImgUrl());
        productMapper.insertProduct(product);
    }

    @Override
    public void deleteProduct(Integer productNo,Integer userId) {
        Map<String,Integer> map=new HashMap<>();
        map.put("productId",productNo);
        map.put("productUserNo",userId);
        productMapper.deleteByProductIdAndProductUserNo(map);
    }

    @Override
    public void updateProduct(Product product, Integer userId) {
        Product updateProduct=new Product();
        updateProduct.setProductId(product.getProductId());
        updateProduct.setProductCategory(product.getProductCategory());
        updateProduct.setProductName(product.getProductName());
        updateProduct.setProductPrice(product.getProductPrice());
        updateProduct.setProductDescription(product.getProductDescription());
        updateProduct.setProductUserNo(userId);
        updateProduct.setProductQuantity(product.getProductQuantity());
        updateProduct.setProductImgUrl(product.getProductImgUrl());
        productMapper.updateByProductIdSelective(updateProduct);
    }

    @Override
    public Integer getProductCountByCategory(String category) {
        return productMapper.CountTotalProduct(category);
    }

    @Override
    public Integer getProductResultCountByKeyword(String keyword) {
        return productMapper.ResultCountTotalProduct(keyword);
    }
}
