package com.bobocode.demo;

import com.bobocode.demo.service.ProductInfoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("com.bobocode.demo");
        var productInfoService = context.getBean(ProductInfoService.class);
        var productName = "   T-Shirt   ";
        var producerName = "        Bobocode";
        var price = 1000;
        var discountAmount = 25;

        System.out.println(productInfoService.composeAdvertisement(productName, price, producerName, discountAmount));
//        System.out.println(productInfoService.getClass());
    }
}
