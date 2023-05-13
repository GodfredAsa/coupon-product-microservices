package com.productservice.productservice.restcontroller;

import com.productservice.productservice.model.dto.Coupon;
import com.productservice.productservice.model.Product;
import com.productservice.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/api/products")
public class ProductRestController {

    @Autowired private ProductRepository productRepository;
    @Autowired private RestTemplate restTemplate;

    @Value("${couponService.url}")
    private String couponServiceUrl;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product cresteProduct(@RequestBody Product product){
        if(product.getCouponCode() =="") return productRepository.save(product);
        Coupon coupon = restTemplate.getForObject( couponServiceUrl + product.getCouponCode(), Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepository.save(product);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Product findByName(@PathVariable("name") String name){
        System.out.println(productRepository.findByName(name.toLowerCase()));
        return productRepository.findByName(name.toLowerCase());
    }
}
