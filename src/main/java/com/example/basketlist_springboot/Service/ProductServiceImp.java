package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.Product;
import com.example.basketlist_springboot.Dto.Users;
import com.example.basketlist_springboot.Mapper.ProductMapper;
import com.example.basketlist_springboot.Mapper.UsersMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Page<Product> getProductPage(int page, int size) {
        List<Product> productList=productMapper.selectAll();
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage=new PageImpl<>(productList,pageable,productList.size());
        return productPage;
    }

    @Override
    public Page<Product> getProductPageByCategory(String category, int page, int size) {
        List<Product> productList=productMapper.selectByCategory(category);
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage=new PageImpl<>(productList,pageable,productList.size());
        return productPage;
    }

    @Override
    public List<Product> getProductListByUserId(int userId) {
        Users user=usersMapper.selectByUserId(userId);
        if(user.getRole().equals("BUYER")){
            return null;
        }
        List<Product> productList=productMapper.selectProductListByProductUserNo(userId);
        return productList;
    }

    @Override
    public Product getProductByProductNo(int productNo) {
        Product selectedProduct=productMapper.selectByProductId(productNo);
        return selectedProduct;
    }

    @Override
    public Page<Product> searchProductsByKeyWord(String keyword, int page, int size) {
        List<Product> productList=productMapper.selectProductListLikeProductName(keyword);
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage=new PageImpl<>(productList,pageable,productList.size());
        return productPage;
    }

    @Override
    public Product addProduct(Product product,Integer userId) {
        Product newProduct=new Product();
        newProduct.setProductCategory(product.getProductCategory());
        newProduct.setProductName(product.getProductName());
        newProduct.setProductPrice(product.getProductPrice());
        newProduct.setProductDescription(product.getProductDescription());
        newProduct.setProductUserNo(userId);
        newProduct.setProductQuantity(product.getProductQuantity());
        newProduct.setProductImgUrl(product.getProductImgUrl());
        productMapper.insertProduct(product);
        return newProduct;
    }

    @Override
    public void deleteProduct(Integer productNo,Integer userId) {
        Map<String,Integer> map=new HashMap<>();
        map.put("productId",productNo);
        map.put("productUserNo",userId);
        productMapper.deleteByProductIdAndProductUserNo(map);
    }
}
