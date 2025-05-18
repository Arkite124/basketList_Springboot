package com.example.basketlist_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.basketlist_springboot.Mapper")
@SpringBootApplication
public class BasketListSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasketListSpringbootApplication.class, args);
    }

}
