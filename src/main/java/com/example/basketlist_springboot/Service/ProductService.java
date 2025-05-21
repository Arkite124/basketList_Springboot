package com.example.basketlist_springboot.Service;

import com.example.basketlist_springboot.Dto.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProductListByCategory(String category);
}
